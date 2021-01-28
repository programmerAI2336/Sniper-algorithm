import java.awt.*;
import java.awt.geom.AffineTransform;

public class Bot extends Entity {
    private final Player player;
    private double gunAngle;

    public Bot(Player player) {
        this.player = player;
    }

    {
        x = 658;
        y = 359;
        width = 50;
        length = 50;
    }

    private void paintLaze(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform laze = new AffineTransform();
        g2d.setColor(Color.MAGENTA);
        g2d.rotate(gunAngle, 683, 384);
        g2d.fillRect(683, 384, 600, 1);
        g2d.setTransform(laze);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, width, length);
        paintLaze(g);
    }

    private double getAngleBetween2Vector() {
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

        return Math.toDegrees(Math.acos(cosOfAngle1));
    }

    private double getExtraShootAngle() {
        // This is the angle between the Vector 1 and main shoot angle.
        double playerSpeed = Math.sqrt(Math.pow(player.xSpeed, 2) + Math.pow(player.ySpeed, 2));
        double ammoSpeed = 10;
        double sinOfExtraShootAngle = playerSpeed / ammoSpeed * Math.sin(Math.toRadians(getAngleBetween2Vector())); // Unit : degrees.
        return Math.toDegrees(Math.asin(sinOfExtraShootAngle));
    }

    private double getPlayerNextPosAngle() {
        double nextPosX = player.x + player.xSpeed;
        double nextPosY = player.y + player.ySpeed;
        double nextPosAngle; // Unit : degrees.

        double extraAngle = Math.toDegrees(Math.atan((nextPosY - y) / (nextPosX - x))); // Unit : degrees.
        if (nextPosX > x) {
            if (nextPosY > y) {
                nextPosAngle = extraAngle;
            } else {
                nextPosAngle = extraAngle + 360;
            }
        } else {
            nextPosAngle = extraAngle + 180;
        }
        return nextPosAngle;
    }

    private double getPlayerAngle() {
        double playerAngle; // Unit : degrees.
        double extraAngle = Math.toDegrees(Math.atan((player.y - y) / (player.x - x))); // Unit : degrees.
        if (player.x > x) {
            if (player.y > y) {
                playerAngle = extraAngle;
            } else {
                playerAngle = extraAngle + 360;
            }
        } else {
            playerAngle = extraAngle + 180;
        }
        return playerAngle;
    }

    public void aim() {
        double playerSpeed = Math.sqrt(Math.pow(player.xSpeed, 2) + Math.pow(player.ySpeed, 2));
        double angle;
        if (playerSpeed != 0) {
            if (getPlayerNextPosAngle() > getPlayerAngle()) {
                angle = getPlayerAngle() + getExtraShootAngle();
            } else if (getPlayerNextPosAngle() < getPlayerAngle()) {
                angle = getPlayerAngle() - getExtraShootAngle();
            } else {
                angle = getPlayerAngle();
            }
            gunAngle = Math.toRadians(angle);
        } else {
            gunAngle = Math.toRadians(getPlayerAngle());
        }

    }
}
