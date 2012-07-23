package com.sinosoft.ebusiness.util.web.kaptcha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;


/**
 * kaptcha 用于制造干扰线
 * @author qc
 *
 */
public class FishEyeGimpy extends Configurable implements GimpyEngine {

	public BufferedImage getDistortedImage(BufferedImage baseImage) {
		NoiseProducer noiseProducer = getConfig().getNoiseImpl();
		Graphics2D graph = (Graphics2D) baseImage.getGraphics();
		int imageHeight = baseImage.getHeight();
		int imageWidth = baseImage.getWidth();
		Color color = new Color(204, 204, 204);

		int horizontalGaps = imageHeight / 4;
		int verticalGaps = imageWidth / 5;

		

		for (int i = horizontalGaps; i < imageHeight; i += horizontalGaps) {
			graph.setColor(color);
			graph.drawLine(0, i, imageWidth, i);
		}

		for (int i = verticalGaps; i < imageWidth; i += verticalGaps) {
			graph.setColor(color);
			graph.drawLine(i, 0, i, imageHeight);
		}

		graph.dispose();
		noiseProducer.makeNoise(baseImage, 0.1F, 0.3F, 0.25F, 0.4F);
		noiseProducer.makeNoise(baseImage, 0.1F, 0.25F, 0.5F, 0.9F);
		return baseImage;
	}


}
