package com.neuedu.pojo;

import com.neuedu.client.MaoXianClient;
import com.neuedu.utils.GameUtil;
import com.neuedu.utils.ImgUtil;
import com.neuedu.utils.MusicUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero {
    private static Image[] imgs = new Image[100];

    static {
        for (int i = 0; i <= 4; i++) {
            imgs[i] = ImgUtil.getImage("hero_right_walk" + i);
        }
        for (int i = 5; i <= 9; i++) {
            imgs[i] = ImgUtil.getImage("hero_left_walk" + (i - 5));
        }
        for (int i = 10; i <= 13; i++) {
            imgs[i] = ImgUtil.getImage("hero_right_shoot" + (i - 10));
        }
        for (int i = 14; i <= 17; i++) {
            imgs[i] = ImgUtil.getImage("hero_left_shoot" + (i - 14));
        }
    }

    private Image image;
    private int x;
    private int y;
    private int height;
    private int width;
    private int speed = 10;
    private boolean left, right;
    private Direction dir;
    private Action action;
    private boolean walk;
    private boolean shoot;
    private boolean jump;
    private MaoXianClient mxc;

    public Hero(MaoXianClient mxc) {
        this.mxc = mxc;
        this.image = ImgUtil.getImage("hero_right_stand");
        this.x = 10;
        this.height = image.getHeight(null);
        this.width = image.getWidth(null);
        this.y = Constant.GAME_HEIGHT - height - 120;
        this.dir = Direction.RIGHT;
        this.action = Action.STAND;
    }

    private int walk_right_count = 0;
    private int walk_left_count = 5;
    private int shoot_right_count = 10;
    private int shoot_left_count = 14;

    public void draw(Graphics g) {
        if (walk_right_count > 4) {
            walk_right_count = 0;
        }
        if (walk_left_count > 9) {
            walk_left_count = 5;
        }
        if (shoot_right_count > 13) {
            shoot_right_count = 10;
        }
        if (shoot_left_count > 17) {
            shoot_left_count = 14;
        }
        switch (this.dir) {
            case RIGHT:
                switch (this.action) {
                    case STAND:
                        g.drawImage(image, x, y, null);
                        break;
                    case WALK:
                        g.drawImage(imgs[walk_right_count++], x, y, null);
                        break;
                    case SHOOT:
                        g.drawImage(imgs[shoot_right_count++], x, y, null);
                        break;
                    case JUMP:
                        g.drawImage(ImgUtil.getImage("hero_right_jump"), x, y, null);
                        break;
                }
                break;
            case LEFT:
                switch (this.action) {
                    case STAND:
                        g.drawImage(ImgUtil.getImage("hero_left_stand"), x, y, null);
                        break;
                    case WALK:
                        g.drawImage(imgs[walk_left_count++], x, y, null);
                        break;
                    case SHOOT:
                        g.drawImage(imgs[shoot_left_count++], x, y, null);
                        break;
                    case JUMP:
                        g.drawImage(ImgUtil.getImage("hero_left_jump"), x, y, null);
                        break;
                }

                break;
        }

        move();
        /*if (x >= 300) {
            g.drawImage(GameUtil.getImg("com/neuedu/img/door/0.png"), 1082, 80, null);
        }*/
    }


    public void move() {
        if (shoot) {
            shoot();
        }
        if (jump) {
            jump();
        }

        if (right) {
            this.dir = Direction.RIGHT;

        } else if (left) {
            this.dir = Direction.LEFT;

        }
        if (walk) {
            if (right) {
                this.action = Action.WALK;
                x += speed;
            } else if (left) {
                this.action = Action.WALK;
                x -= speed;
            }
        } else if (shoot) {
            this.action = Action.SHOOT;
        } else if (jump) {
            this.action = Action.JUMP;
        } else {
            this.action = Action.STAND;
        }

//        for (int i=0;i<=50;i++){
//            if(x>650+i*10&&x<650+(i+1)*10){
//                y=500-20*i;
//            }
//        }


        if (x >670 && x<=674) {
            y = 600 - height;
        } else if (x == 675 || x == 699) {
            y = 491;
        } else if (x == 700 || x == 723) {
            y = 465;
        } else if (x == 724 || x == 747) {
            y = 438;
        } else if (x == 748 || x == 772) {
            y = 412;
        } else if (x == 773 || x == 796) {
            y = 385;
        } else if (x == 797 || x == 821) {
            y = 359;
        } else if (x == 822 || x == 845) {
            y = 332;
        } else if (x == 846 || x == 870) {
            y = 306;
        } else if (x == 871 || x == 894) {
            y = 279;
        } else if (x == 895 || x == 921) {
            y = 253;
        } else if (x == 920 || x == 943) {
            y = 226;
        } else if (x == 944 || x == 960) {
            y = 204;
        }


        outofBind();
    }

    /*将移动范围固定在指定的范围内*/
    public void outofBind() {
        if (x < 0) {
            x = 0;
        }
        if (x > Constant.GAME_WIDTH - width) {
            x = Constant.GAME_WIDTH - width;
        }
    }

    public void keyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                right = true;
                walk = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                walk = true;
                break;
            case KeyEvent.VK_K:
                shoot = true;
                break;
            case KeyEvent.VK_J:

                jump = true;
                break;

        }
    }

    public void keyRelease(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                right = false;
                walk = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                walk = false;
                break;
            case KeyEvent.VK_K:
                shoot = false;
                break;
//            case KeyEvent.VK_J:
//
//                jump=false;
//                break;
        }
    }

    public void shoot() {
        MusicUtil.getMUsic("D:\\开发工具\\IDEA\\Maoxiandao\\src\\com\\neuedu\\img\\bullet.wav");
        if (this.dir == Direction.RIGHT) {
            Bullet bullet = new Bullet(x + width * 2 - 10, y + height / 2, this.dir, mxc);
            mxc.bullets.add(bullet);
        } else if (this.dir == Direction.LEFT) {
            Bullet bullet = new Bullet(x - width * 2 - 10, y + height / 2, this.dir, mxc);
            mxc.bullets.add(bullet);
        }

    }


    /*跳的逻辑处理*/
    private double v0 = 30;
    private double t = 5;
    private static final double g = 9.8;
    private double vt = 0;

    private double changHeight = 0;
    /*是否为竖直上抛的标识*/
    private boolean jump_up = true;

    public void jump() {
        if (jump_up) {
            vt = v0 - g * t;
            changHeight = v0 * t;
            v0 = vt;
            if (vt < 0) {
                v0 = 0;
                vt = 0;
                y -= changHeight;
                jump_up = false;
            }
        } else {
            vt = v0 + g * t;
            changHeight = v0 * t;
            v0 = vt;
            y += changHeight;
            if (x <= 675) {
                if (y > Constant.GAME_HEIGHT - 120 - height) {
                    y = Constant.GAME_HEIGHT - 120 - height;
                    v0 = 30;
                    vt = 0;
                    jump_up = true;
                    jump = false;

                }
            } else if (x > 675 && x <= 700) {
                    if (y > 491) {
                        y = 491;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 700 && x <= 724) {
                    if (y > 465) {
                        y = 465;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 724 && x <= 748) {
                    if (y > 438) {
                        y = 438;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 748 && x <= 773) {
                    if (y > 412) {
                        y = 412;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 773 && x <= 797) {
                    if (y > 385) {
                        y = 385;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 797 && x <= 822) {
                    if (y > 359) {
                        y = 359;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 822 && x <= 846) {
                    if (y > 332) {
                        y = 332;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 846 && x <= 871) {
                    if (y > 306) {
                        y = 306;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 871 && x <= 895) {
                    if (y > 279) {
                        y = 279;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 895 && x <= 920) {
                    if (y > 253) {
                        y = 253;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;

                    }
                } else if (x > 920 && x <= 944) {
                    if (y > 226) {
                        y = 226;
                        v0 = 30;
                        vt = 0;
                        jump_up = true;
                        jump = false;
                    }
                } else if (x > 944 && x <= 1280) {
                       if (y > 204) {
                            y = 204;
                            v0 = 30;
                            vt = 0;
                            jump_up = true;
                            jump = false;

                        }
                 }


        }
    }

}

