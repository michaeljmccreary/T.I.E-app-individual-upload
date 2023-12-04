import java.awt.Component;
import javax.swing.*;
import java.util.Arrays;
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
public class Breathing extends MoodImprovementPlanGUI{
    
    
    public Breathing(UserGUI userGUI){
        super(userGUI);
        setTitle("Breathing Tips");
    }

    
    @Override
    public String generateTips(String activity, Component parentComponent){
        // Implement breathing  tips...
        List<String> breathingTips = Arrays.asList(
                "Practice deep breathing exercises to calm your mind. ",
                "Try diaphragmatic breathing for relaxation.",
                "Inhale slowly, hold your breath, and exhale deeply for a calming effect. ",
                "Experiment with alternate nostril breathing for balance and focus. ",
                "Use calming scents like lavender or chamomile during your breathing exercises. ",
                "Practice square breathing: inhale, hold, exhale, hold—each for a count of four. ",
                "Explore guided breathing exercises available online for variety ",
                "Try progressive muscle relaxation in combination with your breathing routine. ",
                "Create a dedicated space for your breathing exercises with comfortable seating. ",
                "Use positive affirmations during your breathing sessions to enhance relaxation. ",
                "Take deep breathes in through your nose, hold for a moment and exhale slowly through your mouth. repeat this process. ",
                "Practice mindful breathing by focusing on the sensation of your breath. ",
                "Incorporate breathing exercises into your daily routine for consistent benefits. ",
                "Join a local meditation or breathing class to connect with a community. ",
                "Consider using a breathing app to guide and track your practice. ",
                "Experiment with different breathing patterns to find what works best for you. ",
                "Avoid shallow chest breathing; focus on deep, diaphragmatic breaths. ",
                "Combine breathing exercises with gentle stretching for a holistic approach. ",
                "Use props like a cushion or blanket to support your comfort during practice. ",
                "Stay consistent with your breathing routine to experience long-term benefits. "
        );

        
        // Implement tips related to journaling
        String isJournalingStatus = getIsJournalingStatus();
        StringBuilder tipsMessage = new StringBuilder("Breathing Tips:\n\n");

        
        if("Yes".equalsIgnoreCase(isJournalingStatus)){
            tipsMessage.append("Keep up the good work with your journaling!\n");
            tipsMessage.append("Regular journaling can enhance the benefits of your breathing exercises.\n");
        } else{
            tipsMessage.append("Consider starting a journaling routine to complement your breathing exercises.\n");
            tipsMessage.append("Journaling can help you track your progress and emotional well-being.\n");
        }

        
        // Shuffle the breathing tips for randomisation
        Collections.shuffle(breathingTips);

        
        // Determine the number of tips to display (you can adjust this number)
        int numberOfTipsToShow = 5;

        
        // Build the breathing tips message with the randomly selected subset
        for(int i = 0; i < numberOfTipsToShow && i < breathingTips.size(); i++){
            tipsMessage.append("- ").append(breathingTips.get(i)).append("\n");
        }
    
        // Return the breathing tips as a String
        return tipsMessage.toString();
    }
}
