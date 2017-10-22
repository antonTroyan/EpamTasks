package by.tc.task01.service;

import java.io.FileWriter;
import java.io.IOException;

public class FileFiller {


    public void fillFileDefault(String filename) {

        try (FileWriter writer = new FileWriter(filename, false)) {
            String text = "Oven : POWER_CONSUMPTION=1000, WEIGHT=10, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5;\n" +
                    "Oven : POWER_CONSUMPTION=1500, WEIGHT=12, CAPACITY=33, DEPTH=60, HEIGHT=45, WIDTH=68;\n" +
                    "Oven : POWER_CONSUMPTION=2000, WEIGHT=11, CAPACITY=33, DEPTH=60, HEIGHT=40, WIDTH=70;\n" +
                    "\n" +
                    "Laptop : BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHES=18;\n" +
                    "Laptop : BATTERY_CAPACITY=1.5, OS=Linux, MEMORY_ROM=8000, SYSTEM_MEMORY=1000, CPU=2.2, DISPLAY_INCHES=19;\n" +
                    "Laptop : BATTERY_CAPACITY=3, OS=Windows, MEMORY_ROM=8000, SYSTEM_MEMORY=1500, CPU=3.2, DISPLAY_INCHES=22;\n" +
                    "\n" +
                    "Refrigerator : POWER_CONSUMPTION=100, WEIGHT=20, FREEZER_CAPACITY=10, OVERALL_CAPACITY=300, HEIGHT=200, WIDTH=70;\n" +
                    "Refrigerator : POWER_CONSUMPTION=200, WEIGHT=30, FREEZER_CAPACITY=15, OVERALL_CAPACITY=300, HEIGHT=180, WIDTH=80;\n" +
                    "Refrigerator : POWER_CONSUMPTION=150, WEIGHT=35, FREEZER_CAPACITY=20, OVERALL_CAPACITY=350.5, HEIGHT=250, WIDTH=75;\n" +
                    "\n" +
                    "VacuumCleaner : POWER_CONSUMPTION=100, FILTER_TYPE=A, BAG_TYPE=A2, WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=3000, CLEANING_WIDTH=20;\n" +
                    "VacuumCleaner : POWER_CONSUMPTION=110, FILTER_TYPE=B, BAG_TYPE=AA-89, WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=2900, CLEANING_WIDTH=25;\n" +
                    "VacuumCleaner : POWER_CONSUMPTION=90, FILTER_TYPE=C, BAG_TYPE=XX00, WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=2950, CLEANING_WIDTH=30;\n" +
                    "\n" +
                    "TabletPC : BATTERY_CAPACITY=3, DISPLAY_INCHES=14, MEMORY_ROM=8000, FLASH_MEMORY_CAPACITY=2, COLOR=blue;\n" +
                    "TabletPC : BATTERY_CAPACITY=4, DISPLAY_INCHES=15, MEMORY_ROM=8000, FLASH_MEMORY_CAPACITY=6, COLOR=red;\t\n" +
                    "TabletPC : BATTERY_CAPACITY=5, DISPLAY_INCHES=16, MEMORY_ROM=16000, FLASH_MEMORY_CAPACITY=8, COLOR=green;\n" +
                    "\n" +
                    "Speakers : POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2;\n" +
                    "Speakers : POWER_CONSUMPTION=20, NUMBER_OF_SPEAKERS=3, FREQUENCY_RANGE=3-4, CORD_LENGTH=3;\n" +
                    "Speakers : POWER_CONSUMPTION=17, NUMBER_OF_SPEAKERS=4, FREQUENCY_RANGE=2-3.5, CORD_LENGTH=4;";
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

