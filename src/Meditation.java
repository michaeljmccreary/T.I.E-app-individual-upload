import java.awt.Component;
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
public class Meditation extends MoodImprovementPlanGUI{
    
    
       public Meditation(UserGUI userGUI){
        super(userGUI);
        setTitle("Meditation Tips");
    }
       
    @Override
    public String generateTips(String activity, Component parentComponent){
        // Implement meditation tips...
        List<String> meditationTips = Arrays.asList(
            "Calm your mind with deep breathing exercises. ",
            "Experience relaxation through diaphragmatic breathing. ",
            "Practice a calming breath sequence: inhale slowly, hold, exhale deeply. ",
            "Achieve balance and focus with alternate nostril breathing. ",
            "Enhance your breathing exercises with calming scents like lavender or chamomile. ",
            "Try square breathing: inhale, hold, exhale, hold—each for a count of four. ",
            "Explore a variety of guided breathing exercises available online. ",
            "Combine progressive muscle relaxation with your breathing routine. ",
            "Create a dedicated and comfortable space for your breathing exercises. ",
            "Boost relaxation with positive affirmations during your breathing sessions. ",
            "Immerse yourself in mindful breathing by focusing on the sensation of your breath. ",
            "Integrate breathing exercises into your daily routine for consistent benefits. ",
            "Connect with a community by joining a local meditation or breathing class. ",
            "Enhance your practice with a breathing app for guidance and tracking. ",
            "Discover what works best for you by experimenting with different breathing patterns. ",
            "Avoid shallow chest breathing and focus on deep, diaphragmatic breaths. ",
            "Adopt a holistic approach by combining breathing exercises with gentle stretching. ",
            "Support your comfort during practice with props like a cushion or blanket. ",
            "Experience long-term benefits by staying consistent with your breathing routine. "
        );

        
        StringBuilder tipsMessage = new StringBuilder("Meditation Tips:\n\n");
  
        // Shuffle the meditation tips for randomisation
        Collections.shuffle(meditationTips);

        
        // Determine the number of tips to display (you can adjust this number)
        int numberOfTipsToShow = 5;

        
        // Build the meditation tips message with the randomly selected subset
        for(int i = 0; i < numberOfTipsToShow && i < meditationTips.size(); i++){
            tipsMessage.append("- ").append(meditationTips.get(i)).append("\n");
        }
        
        // Return the meditation tips as a String
        return tipsMessage.toString();
    }
}
