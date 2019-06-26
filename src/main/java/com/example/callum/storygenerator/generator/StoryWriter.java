package com.example.callum.storygenerator.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Write story to file
 */
public class StoryWriter
{
	private static final Logger logger = LoggerFactory.getLogger(StoryWriter.class);

	public void writeStory(String outputFileName, StringBuffer sb)
	{
		logger.info("Writing story");
		try
		{
			// If output file already exists then delete it
			File outFile = new File(outputFileName);

			if (outFile.exists())
			{
				logger.info(outFile.getName() + " already exists, deleting it");
				outFile.delete();
			}
			// Create a file in the directory
			outFile.createNewFile();

			// Write to the file
			FileWriter fw = new FileWriter(outFile);
			PrintWriter pw = new PrintWriter(fw);

			logger.info("Writing story to file " + outputFileName);
			pw.print(sb.toString());

			// Clean up
			fw.flush();
			fw.close();
			pw.flush();
			pw.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
