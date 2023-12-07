
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
 * @author Michael McCreary - x22171363
 */
public class Yoga extends MoodImprovementPlanGUI{
    
    
    public Yoga(UserGUI userGUI){
        super(userGUI);
        setTitle("Yoga Tips");
    }
    
    
    @Override
    public String generateTips(String activity, Component parentComponent){
        // Implement yoga tips...
        List<String> yogaTips = Arrays.asList(
                "Practice the many different Yoga poses for stability and balance. ",
                "Try the Downward Facing Dog pose to stretch your entire body. ",
                "Focus on your breathing during the Warrior Pose for strength. ",
                "End your session with the Corpse Pose for relaxation. ",
                "Incorporate Sun Salutations into your routine for a full-body stretch. ",
                "Experiment with different yoga styles to find what suits you best. ",
                "Use props like blocks and straps to modify poses and enhance your practice. ",
                "Create a calming atmosphere with soft lighting and soothing music during your practice. ",
                "Stay hydrated before, during, and after your yoga session. ",
                "Listen to your body and modify poses as needed to avoid strain. ",
                "Practice mindfulness by being fully present in each yoga pose. ",
                "Explore online yoga classes to diversify your practice. ",
                "Join a local yoga class or community to connect with others. ",
                "Set intentions for your practice to cultivate a positive mindset. ",
                "Include balance poses to improve stability and focus. ",
                "Experiment with guided yoga nidra (yogic sleep) for deep relaxation. ",
                "Pay attention to your breath pattern and work on rhythmic breathing. ",
                "Challenge yourself with advanced poses as you progress in your practice. ",
                "Practice yoga regularly to experience long-term physical and mental benefits. ",
                "Listen to meditation music while attempting Yoga for a tranquil expierence. "
        );

        StringBuilder tipsMessage = new StringBuilder("Yoga Tips:\n\n");
      
        // Shuffle the yoga tips for randomisation
        Collections.shuffle(yogaTips);

        
        // Determine the number of tips to display (you can adjust this number)
        int numberOfTipsToShow = 5;

        
        // Build the yoga tips message with the randomly selected subset
        for(int i = 0; i < numberOfTipsToShow && i < yogaTips.size(); i++){
            tipsMessage.append("- ").append(yogaTips.get(i)).append("\n");
        }
        
        // Return the yoga tips as a String
        return tipsMessage.toString();
    }  
}
