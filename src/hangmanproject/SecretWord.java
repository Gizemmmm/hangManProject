/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanproject;

/**
 *
 * @author GİZEM
 */
public class SecretWord
{
    String clue, visible, secret;
    int count=0;

public SecretWord()
{
    String [] wordList = { "Murat Ak", "07", "Ankara", "Java" };
    
    String [] clueList = { "Who is  CSE102 teacher at Akdeniz University ", "what is plate number of Antalya", "Where is the capital city of Turkey?", "Which programming language did we use in our lesson?" };
    int rand;
    rand = (int) (Math.random()*4);
    secret = wordList[rand];
    clue = clueList[rand];
    int wordLength = secret.length();
    
    visible = "";
   
    for ( int i = 0; i < secret.length(); i++)
    {
        char c = secret.charAt(i);
        
        if ( c == ' ' )
            visible += c;
        else
            visible += '*';
    }
}

public String getClue()
{
    return clue;
}

public String toString()
{
    // String s = "";
    // for(int i = 0; i < wordLength; i++)
    //    s = s + "_ ";
    // return s;
    
    return visible;
}

    // provided by Group 4 and 8
    public boolean update(char c)
    {
        char[] secretArray = new char [secret.length()];
        char[] visibleArray = new char [secret.length()];
        String s = "";
        boolean contains = false ;
        
        //We make the String secret an array
        for(int i = 0; i < secret.length(); i++)
        {
            secretArray[i] = secret.charAt(i);
            visibleArray[i] = visible.charAt(i);
        }
        
        //We are uptading our empty visible array
        for(int k = 0; k < secret.length();k++)
        {
            
            if(secretArray[k] == c)
            {
                visibleArray[k] = c;
                contains = true;
            }
        }
        //We are changing our visible array into the visible string
        for(int m=0; m < secret.length(); m++ )
        {
            s = s + visibleArray[m];
        }
        visible = s;
        
        return contains;
   }
    //This is a method to check if the secret word is solved
    public boolean isSolved()
    {   
        return secret.equalsIgnoreCase(visible);
    }
}
