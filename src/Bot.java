import java.awt.*;

public class Bot extends Entity {
    private final Player player;

    public Bot(Player player) {
        this.player = player;
    }

    {
        x = 658;
        y = 359;
        width = 50;
        length = 50;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, width, length);
    }
     
    private double getAngleBetween2Vector(){
        // Using vector calculation formula.
        // Link: https://www.mathvn.com/2019/12/cong-thuc-tinh-goc-giua-hai-vecto-trong.html

        double vector1Width = x - player.y;
        double vector2Width = player.xSpeed;
        double vector1Length = y - player.y;
        double vector2Length = player.ySpeed;

        // Vector 1 is the line from player to bot.
        // Vector 2 is the player's speed.

        double cosOfAngle1 = (vector1Width * vector2Width + vector1Length * vector2Length) / 
        (Math.sqrt(Math.pow(vector1Width, 2) + Math.pow(vector1Length, 2)) * Math.sqrt(Math.pow(vector2Width, 2) + Math.pow(vector2Length, 2)));

        double angleBetween2Vector = Math.toDegrees(Math.acos(cosOfAngle1)); // Unit : degrees.
        return angleBetween2Vector;
    }

    private double getExtraShootAngle(){
        // This is the angle between the Vector 1 and main shoot angle.
        double playerSpeed = Math.sqrt(Math.pow(player.xSpeed, 2) + Math.pow(player.ySpeed, 2));
        double ammoSpeed = 10;
        double extraShootAngle = playerSpeed / ammoSpeed * getAngleBetween2Vector; // Unit : degrees.
        return extraShootAngle;
    } 
    
    private double getPlayerNextPosAngle(){
        double nextPosX = player.x + xSpeed;
        double nextPosY = player.y + ySpeed;
        double nextPosAngle = 0; // Unit : degree.
        
        double extraAngle = Math.toDegrees(Math.atan((nextPosY - y)/(nextPosX = x))) // Unit : degree.
        if(nextPosX > x){
           if(nextPosY > y){
              nextPosAngle = extraAngle;
           } else {
              nextPosAngle = extraAngle + 360;
           }
        } else {
           nextPosAngle = extraAngle + 180;
        }
       return nextPosAngle;
    }  

    public void aim() {
         
    }
}
