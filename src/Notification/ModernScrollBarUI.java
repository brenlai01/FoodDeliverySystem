package Notification;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class ModernScrollBarUI extends BasicScrollBarUI {

    private final int THUMB_SIZE = 60;
    
    @Override
    protected Dimension getMaximumThumbSize() {
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0,40);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }
    
    @Override
    protected Dimension getMinimumThumbSize() {
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0,40);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }
    
    @Override
    protected JButton createIncreaseButton(int i) {
        return new ScrollBarButton();
    }
    
    @Override
    protected JButton createDecreaseButton(int i) {
        return new ScrollBarButton();
    }
    
    @Override
    protected void paintTrack(Graphics graphics, JComponent jc, Rectangle rectangle){
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientation = scrollbar.getOrientation();
        int size; 
        int x;
        int y;
        int width;
        int height;
        
        if (orientation == JScrollBar.VERTICAL) {
            size = rectangle.width / 2;
            x = rectangle.x + ((rectangle.width - size) / 2);
            y = rectangle.y;
            width = size;
            height = rectangle.height;
        } else {
            size = rectangle.height / 2;
            y = rectangle.y + ((rectangle.height - size) / 2);
            x = 0;
            width = rectangle.width;
            height = size;
        }
        g2.setColor(new Color(240,240,240));
        g2.fillRect(x, y, width, height);
    }
    
    @Override
    protected void paintThumb(Graphics graphics, JComponent jc, Rectangle rectangle) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = rectangle.x;
        int y = rectangle.y;
        int width = rectangle.width;
        int height = rectangle.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL){
            y += 8;
            height -= 16;
        } else {
            x += 8;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 10, 10);
    }
    
    private class ScrollBarButton extends JButton{
        
        public ScrollBarButton(){
            setBorder(BorderFactory.createEmptyBorder());
        }
        
        @Override
        public void paint(Graphics graphics){
            
        }
    }
}
