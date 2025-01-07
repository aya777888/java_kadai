package game;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BackGround {
    //背景（幹、雲、空）
        Image miki,sky,cloud,title;
        int miki_y[],cloud_y[],image_speed,miki_size_y,n_miki,n_cloud;
        protected int width;
        protected int height;

    public BackGround() {
        width=800;height=1000;
        //背景（幹、雲、空）
        n_miki=20;n_cloud=40;
        ImageIcon icon_title=new ImageIcon("title.png");
        title=icon_title.getImage();
        ImageIcon icon_miki_1=new ImageIcon("miki1.png");
        miki=icon_miki_1.getImage();
        ImageIcon icon_sky=new ImageIcon("sky.png");
        sky=icon_sky.getImage();
        ImageIcon icon_cloud=new ImageIcon("kumo.png");
        cloud=icon_cloud.getImage();
        miki_size_y=miki.getHeight(this);
        cloud_y=new int[n_cloud];
        for(int l=0;l<n_cloud;l++){
            cloud_y[l]=-miki_size_y*l/2;
        }
        miki_y=new int[n_miki];
        for(int j=0;j<n_miki;j++){
            miki_y[j]=-miki_size_y*j*11/12;
        }
        image_speed=10;
    }

    public void update() {
        //背景（幹、雲、空)
               for(int j=0;j<n_miki;j++){
                miki_y[j]+=image_speed;
               }
               for(int l=0;l<n_cloud;l++){
                cloud_y[l]+=image_speed;
               }
    }

    public void render(Graphics2D g) {
         //空
         g.drawImage(sky,0,0,width,height,this);
         //幹
         for(int j=0;j<n_miki;j++){
            g.drawImage(miki,width/4,miki_y[j],width/2,height,this);
        }  
         //雲
        for(int l=0;l<n_cloud;l++){
        if(l%2==0){
            g.drawImage(cloud,width/4-50,cloud_y[l],150,150,this); 
        }else{
            g.drawImage(cloud,width*3/4-60,cloud_y[l],150,150,this);
        }       
        }
    }
}
