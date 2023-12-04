import java.awt.Component;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author micha
 */
public class Visualisation extends MoodImprovementPlanGUI{
    
    
        public Visualisation(UserGUI userGUI){
        super(userGUI);
        setTitle("Visualisation Tips");
    }

        
    @Override
    public String generateTips(String activity, Component parentComponent){
        // Implement visualisation tips...
        List<String> visualisationTips = new ArrayList<>();
        visualisationTips.add("Choose a quiet and comfortable space for your visualisation practice. ");
        visualisationTips.add("Close your eyes and take a few deep breaths to relax your body and mind. ");
        visualisationTips.add("Create vivid mental images of a peaceful and serene place, focusing on details. ");
        visualisationTips.add("Engage multiple senses in your visualisation, including sight, sound, touch, and smell. ");
        visualisationTips.add("Imagine yourself achieving your goals and experiencing success. ");
        visualisationTips.add("Visualise a protective shield of positive energy around you. ");
        visualisationTips.add("Practice gratitude by visualising things you are thankful for in detail. ");
        visualisationTips.add("Visualise a future version of yourself and the positive changes you want to make. ");

        
        // Implement tips related to journaling
        String isJournalingStatus = getIsJournalingStatus();
        StringBuilder tipsMessage = new StringBuilder("Visualisation Tips:\n\n");

        
        if("Yes".equalsIgnoreCase(isJournalingStatus)){
            tipsMessage.append("Keep up the good work with your journaling!\n");
            tipsMessage.append("Regular journaling can enhance the effectiveness of your visualisation practice.\n");
        } else{
            tipsMessage.append("Consider starting a journaling routine to record your visualisation experiences.\n");
            tipsMessage.append("Journaling can help you notice patterns and changes in your thoughts and emotions.\n");
        }
           
        
        // Shuffle the Visualisation tips for randomisation
        Collections.shuffle(visualisationTips);
        
        
        // Build the visualisation tips message
        for(String tip : visualisationTips){
            tipsMessage.append("- ").append(tip).append("\n");
        }
        
        
        // Determine the number of tips to display (you can adjust this number)
        int numberOfTipsToShow = 5;
        
        
        // Build the Visualisation tips message with the randomly selected subset
        for(int i = 0; i < numberOfTipsToShow && i < visualisationTips.size(); i++){
            tipsMessage.append("- ").append(visualisationTips.get(i)).append("\n");
        }

 
        // Return the visualisation tips as a String
        return tipsMessage.toString();
    }
}
