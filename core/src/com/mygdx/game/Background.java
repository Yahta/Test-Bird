package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

    void update() {
        for (int i = 0; i < backs.length; i++) {
            backs[i].pos.x -= speed;
        }

        if(backs[0].pos.x < -800){
            backs[0].pos.x = 0;
            backs[1].pos.x = 800;
    }
    }

    class BGPicture {
        private Texture tx; // (_4_) создаем поле текстуры картинки фоном (_19_) переносим в класс BGPicture
        private Vector2 pos;// поле с позицией этой картинки

        public BGPicture(Vector2 pos){
            tx = new Texture("back.png"); // инициализируем картинку
            // pos = new Vector2(0, 0);// задаем позицию картинки (_20_) переносим вектор в параметр метода
            // оттуда будем считывать рначальную позицию картинки
            pos = pos; // (_21_) пишем

        }

    }

    private int speed; // (_11_)скорость, с которой будет перерисовываться
    private BGPicture [] backs; // (_22_) создаем поле массив из объекта класса BGPicture



    public Background() { // (_5_) создаем конструктор

        speed = 4; // (_12_) 4 кадра, т.е на 4 точки будет съезжать фон во время каждой перерисовки
        backs = new BGPicture[2]; // (_23_) в конструкторе положим массив и з двух элементов
        backs[0] = new BGPicture(new Vector2(0,0));
        // (_24_) положим в конструкторе массив из двух элементов
        backs[1] = new BGPicture(new Vector2(800,0)); // в соответсвии со схемой
    }

    public void render(SpriteBatch batch) {
        // (_6_) задаем метод, в котором будут происходить необходимые отрисовки для фона
        // добавляем в скобки параметр
        for (int i = 0; i < backs.length; i++) {
            // (_25_) теперь в методе рендер отрисовываем не одну картинку, а две
            // с помощью цикла фор
            batch.draw(backs[i].tx, backs[i].pos.x, backs[i].pos.y); // (_26_) для каждого элемента
            // batch.draw(tx, pos.x, pos.y); //  собираем в методе батч // (_27) удаляем за ненадобностью
            // (_7_) возвращаемся в Java Class MyGdxGame  и добавляем метод update
        }

       // public void update() {
           // for (int i = 0; i < backs.length; i++) {
             //   backs[i].pos.x -= speed;
            }
        }

        // if (backs[0].pos.x < -800) {
            //backs[0].pos.x = 0;
           //  backs[1].pos.x = 800;
     //   }
   // }