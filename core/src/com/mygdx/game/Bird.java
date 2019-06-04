package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by infuntis on 13/08/17.
 */
public class Bird {
    Texture img; // (_30_) создаем поле текстуры, импортим этот класс
    Vector2 position; // создаем направление для птички
    float vy; // (_36_) направление скорость движение птички вниз, т.е. вектор
    float gravity; // сила гравитации, т.е. на сколько ускоряется движение отрисовки птички книзу


    public Bird(){ // (_31_) создаем конструктор для птички
        img = new Texture("bird1.png"); // делаем присвоение
        position = new Vector2(100,380); // примертно относительно разрешения игры
        vy = 0; // (_37_) прописываем в конструкторе начальное значение
        gravity = - 0.7f; // постоянное значение гравитации
    }

    public void render(SpriteBatch batch){
        batch.draw(img, position.x, position.y); // (_33_)
        // (_34_) теперь птичку добавляем в MyGdxGame в основной класс
    }
    // (_32_) добавляем метод, который будет принимать как параметр Спрайт Батч,
    // с помощью этого объекта отрисовываем все игровые объекты

    public void update(){ // добавляем всю математику, т.е. положение птички

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){ // (_39_) создаем реакцию на нажатие кнопки "пробел"
            // импортим input
            vy = 10; // меняем на 180 градусов направление движения птички,
            // т.е. несколькими нажатиями можем побросить наверх и одним нажатием на 10
        }
        vy += gravity; // (_38_) в методе меняющем положение птички
        // увеличиваем скорость движение птички книзу
        position.y += vy; // горизонтальное положение птички увеличивается, т.е. меняется
    }

    public void recreate(){ // (_70_) создаем метод, который будет пересоздавать игру
        position = new Vector2(100,380);
        vy = 0;
    }
}
// (_40_) создаем новый класс с препядствиями Java Class Obstacles