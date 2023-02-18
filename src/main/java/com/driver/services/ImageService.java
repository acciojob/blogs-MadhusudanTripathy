package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image();

        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        blog.getImageList().add(image);

        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String imageDimensions=imageRepository2.findById(id).get().getDimensions();
        String[] imageXY=imageDimensions.split("X");
        String[] screenXY=screenDimensions.split("X");

        int imageX=Integer.parseInt(imageXY[0]);
        int imageY=Integer.parseInt(imageXY[1]);

        int screenX=Integer.parseInt(screenXY[0]);
        int screenY=Integer.parseInt(screenXY[1]);

        int count=(screenX/imageX)*(screenY/imageY);


        return count;
    }
}
