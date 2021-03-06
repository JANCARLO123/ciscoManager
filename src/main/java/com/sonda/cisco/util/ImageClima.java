package com.sonda.cisco.util;


import com.sonda.cisco.model.ForecastModel;
import com.sonda.cisco.model.clima.Forecast;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * Created by JanCarlo on 18/05/2016.
 */
public class ImageClima {


    public String getDataImage(int ancho, int alto, String img, String temp, String descrpcion, String Ciudad ){

		ByteArrayOutputStream bas = new ByteArrayOutputStream();
        BufferedImage fondo = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics g = fondo.getGraphics();



		try {
			ImageIcon imagen = new ImageIcon(getClass().getResource("iconWater/" +img+".gif"));
			System.out.println(imagen.toString());
			System.out.println(imagen.getIconHeight());


	        	g.setColor(Color.ORANGE);
	        	g.fillRect(0, 0, 298, 489);
	        	g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
	        	g.setColor(Color.WHITE);
	        	g.drawString("Ciudad de México", 110, 35);
	        	g.setFont(new Font(Font.DIALOG, Font.BOLD, 98));
	        	g.drawString(temp.toString()+"", 20, 185);
	        	g.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
	        	g.drawString("°C", 260, 150);
	        	g.drawImage(imagen.getImage(), 350, 100, 120, 120, null);
	        	g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
	        	g.drawString(descrpcion, 50, 240);

			//ImageIO.write(fondo, "PNG", bas);

	        } catch (Exception e) {
	        	e.printStackTrace();
	        }



        CIPImage cipImage = new CIPImage(fondo);
        return cipImage.saveCIPDataToBuffer();

    }

	public byte[] getDataImageByte(int alto, int ancho, String img, String temp, String descrpcion, String Ciudad, String sensacion, String humedad ){

		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		BufferedImage fondo = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = fondo.getGraphics();


		try {

			ImageIcon imagen = new ImageIcon(this.getClass().getResource("/iconWater/" +img+".gif"));

			URL url = new URL("http://icons.wxug.com/i/c/k/"+img+".gif");
			//ImageIcon imagen = new ImageIcon(ImageIO.read(url));

			ImageIcon imagenFondo = new ImageIcon(this.getClass().getResource("/iconWater/fondo.jpg"));

			double d = Double.parseDouble(temp);
			int temint = (int) d;
			String tempString = String.valueOf(temint);


			g.setColor(new Color(0, 174, 239, 127));
			g.fillRect(0, 0, ancho, alto);
			g.drawImage(imagenFondo.getImage(), 0, 0, ancho, alto,null);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
			g.setColor(Color.WHITE);
			g.drawString("Ciudad de México", 130, 35);
			//g.setColor(new Color(66, 90, 131, 220));
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 170));
			g.drawString(tempString, 50, 185);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 70));
			g.drawString("°C", 230, 130);
			g.drawImage(imagen.getImage(), 420, 45, 100, 100, null);

			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
			g.drawString(descrpcion, 50, 260);

			g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			g.drawString("Sensacion termica "+sensacion+"°", 360, 160);
			g.drawString("Humedad "+ humedad, 360, 190);


			ImageIO.write(fondo, "PNG", bas);

		} catch (Exception e) {
			e.printStackTrace();
		}


		return bas.toByteArray();

	}


	public byte[] getDataImageBytePNG(int alto, int ancho, String nombreImagen){

		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		BufferedImage fondo = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = fondo.getGraphics();


		try {
			ImageIcon imagenFondo = new ImageIcon(this.getClass().getResource("/iconWater/" + nombreImagen + ".jpg"));
			//ImageIcon imagenFondo = new ImageIcon(this.getClass().getResource("/iconWater/mision.jpg"));
			g.setColor(new Color(0, 174, 239, 127));
			g.fillRect(0, 0, ancho, alto);
			g.drawImage(imagenFondo.getImage(), 0, 0, ancho, alto,null);
			ImageIO.write(fondo, "PNG", bas);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bas.toByteArray();

	}


	public byte[] getDataImageBytePNGURL(int alto, int ancho, String urlImagen){

		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		BufferedImage fondo = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = fondo.getGraphics();
		try {

			URL url = new URL(urlImagen);
			ImageIcon imagenFondo = new ImageIcon(ImageIO.read(url));
			g.setColor(new Color(0, 174, 239, 127));
			g.fillRect(0, 0, ancho, alto);
			g.drawImage(imagenFondo.getImage(), 0, 0, ancho, alto,null);
			ImageIO.write(fondo, "PNG", bas);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bas.toByteArray();

	}



	public byte[] getDataImageBytePronostico(int alto, int ancho, List<ForecastModel> forecastModels ){

		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		BufferedImage fondo = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = fondo.getGraphics();



		try {

			ImageIcon imagen = new ImageIcon(this.getClass().getResource("/iconWater/"+forecastModels.get(0).getIcon() +".gif"));
			ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("/iconWater/"+forecastModels.get(1).getIcon() +".gif"));
			ImageIcon imagen3 = new ImageIcon(this.getClass().getResource("/iconWater/"+forecastModels.get(2).getIcon() +".gif"));
			ImageIcon imagen4 = new ImageIcon(this.getClass().getResource("/iconWater/"+forecastModels.get(3).getIcon() +".gif"));


			//URL url = new URL("http://icons.wxug.com/i/c/k/"+img+".gif");
			//ImageIcon imagen = new ImageIcon(ImageIO.read(url));.

			ImageIcon imagenFondo = new ImageIcon(this.getClass().getResource("/iconWater/fondo.jpg"));





			g.drawImage(imagenFondo.getImage(), 0, 0, ancho, alto,null);
			g.setColor(new Color(255, 255, 255, 127));

			g.drawRect(0, 0, ancho, alto);
			g.drawRect(1, 1, ancho-1, alto-1);
			g.drawLine(0,alto/2,ancho,alto/2 );
			g.drawLine(ancho/2,0,ancho/2,alto );
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
			g.setColor(Color.WHITE);
			g.drawString("Pronostico", 250, 15);
			//g.setColor(new Color(66, 90, 131, 220));
			//g.setFont(new Font(Font.DIALOG, Font.BOLD, 170));
			g.drawString(forecastModels.get(0).getDay(), 50, 30);
			g.drawString(forecastModels.get(1).getDay(), 370, 30);
			g.drawString(forecastModels.get(2).getDay(), 50, 180);
			g.drawString(forecastModels.get(3).getDay(), 370, 180);

			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
			g.setColor(Color.WHITE);
			g.drawString(forecastModels.get(0).getDate(), 45, 130);
			g.drawString(forecastModels.get(1).getDate(), 355, 130);
			g.drawString(forecastModels.get(2).getDate(), 45, 275);
			g.drawString(forecastModels.get(3).getDate(), 355, 275);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 70));
//			g.drawString("°C", 230, 130);
			g.drawImage(imagen.getImage(), 50, 35, 70, 70, null);
			g.drawImage(imagen2.getImage(), 370, 35, 70, 70, null);
			g.drawImage(imagen3.getImage(), 50, 185, 70, 70, null);
			g.drawImage(imagen4.getImage(), 370, 185, 70, 70, null);



			// max
			g.setColor(new Color(255, 91, 0, 200));

			g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			g.drawString("Max", 180, 55);
			g.drawString("°C", 270, 45);

			g.drawString("Max", 480, 55);
			g.drawString("°C", 570, 45);

			g.drawString("Max", 180, 200);
			g.drawString("°C", 270, 190);

			g.drawString("Max", 480, 200);
			g.drawString("°C",570 , 190);


			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));

			g.drawString(forecastModels.get(0).getMaxC(), 220, 55);
			g.drawString(forecastModels.get(1).getMaxC(), 520, 55);
			g.drawString(forecastModels.get(2).getMaxC(), 220, 200);
			g.drawString(forecastModels.get(3).getMaxC(), 520, 200);

			// min
			g.setColor(new Color(19, 206, 255, 200));


			g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			g.drawString("Min", 180, 115);
			g.drawString("°C", 270, 105);

			g.drawString("Min", 480, 115);
			g.drawString("°C", 570, 105);

			g.drawString("Min", 180, 260);
			g.drawString("°C", 270, 250);

			g.drawString("Min", 480, 260);
			g.drawString("°C",570 , 250);


			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));

			g.drawString(forecastModels.get(0).getMinC(), 220, 115);
			g.drawString(forecastModels.get(1).getMinC(), 520, 115);
			g.drawString(forecastModels.get(2).getMinC(), 220, 260);
			g.drawString(forecastModels.get(3).getMinC(), 520, 260);


			ImageIO.write(fondo, "PNG", bas);

		} catch (Exception e) {
			e.printStackTrace();
		}


		return bas.toByteArray();

	}



	public byte[] getDataImageByteTipoCambio(int alto, int ancho, String dolar, String  euro){
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		BufferedImage fondo = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		Graphics g = fondo.getGraphics();


		try {

			ImageIcon imgdolar = new ImageIcon(this.getClass().getResource("/iconWater/dolar.jpg"));
			ImageIcon imgEuro = new ImageIcon(this.getClass().getResource("/iconWater/euro.png"));


			//ImageIcon imagen = new ImageIcon(ImageIO.read(url));

			ImageIcon imagenFondo = new ImageIcon(this.getClass().getResource("/iconWater/fondo.jpg"));


     	    g.drawImage(imagenFondo.getImage(), 0, 0, ancho, alto,null);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
			g.setColor(Color.WHITE);
			g.drawString("Tipo de Cambio", 200, 25);
			g.drawImage(imgdolar.getImage(), 70, 70, 170, 100, null);
			g.drawImage(imgEuro.getImage(), 390, 70, 170, 100, null);

			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
			g.drawString("Dolar", 95, 60);
			g.drawString("Euro", 415, 60);

			g.drawString("$ "+ dolar, 80, 250);
			g.drawString("$ "+ euro, 400, 250);
//			g.drawString(descrpcion, 50, 260);

			g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));



			ImageIO.write(fondo, "PNG", bas);

		} catch (Exception e) {
			e.printStackTrace();
		}


		return bas.toByteArray();

	}
}


