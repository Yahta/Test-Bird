package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by infuntis on 20/08/17.
 */
public class Obstacles {
    class WallPair{ // (_41_) создаем внутри класс для отображение одной единственной пары труб
        Vector2 position; // создаем поле и импортируем класс
        float speed; // скорость, с которой движется главная пара труб
        int offset; // (_58_) добавляем смещение труб
        Rectangle emptySpace; // (_61_) добавляем новое поле - пустое растрояние между трубами



        public WallPair(Vector2 pos){
            // (_42_) создаем конструктор, который принимает как параметр перенную типа вектор
            position = pos; // делаем присвоение
            speed = 2; // скорость измеряется в количестве пикселей,
            // на которые сдвигается объект за каждую перерисовку
            // поскольку у нас переписовка каждые 60 секунд, 2 будет достаточно
            offset = new Random().nextInt(250); // (_59_) создаем в конструкторе с методом рандом.
            // будет изменть положение вверх или вниз. но чтобы получить разнообразие возвращаемся в метод апдейт
            emptySpace = new Rectangle(position.x, position.y - offset + 300, 50, betweenDistance);
            // (_62_) добавляем в конструкторе. +300 длина Спрайта с трубой, ширина спрайта трубы 50
        }

        public void update(){ // (_43_) создаем метод обновления для каждого экземпляра каждого класса (инстанса)
            position.x -= speed; // (_44_)
            if(position.x < - 50){ // (_56_) если на очередном обновлении меньше 50 пикселей, т.е. ширины трубы
                // и когда она ушла за экран, ее можно воскресить далее
                position.x = 800; // 800 потому что ширина экрана
                offset = new Random().nextInt(250);
            }
            emptySpace.x = position.x; // (_63_) пишем в самом методе отдельно,
            // чтобы не пришлось пррописывать несколько раз слово if
        }
    }

    static WallPair[] obs; // (_45_) будем прописывать поля класса Обстеклс.
    // создаем массив класса WallPair (парные трубы)
    // (_64_) Пишем static чтобы получить доступ к классу отовсюду. и идем в MyGdxGame
    Texture txt; // создаем поле для загрузки картинки
    int betweenDistance; // создаем поле для расстояния между трубами,
    // всегда будет одинаково, но будет изменятся начальная точка для пар трубы

    public Obstacles(){ // создаем конструктор
        txt = new Texture("wall.png"); // добавляем картинку в помощью этого метода
        obs = new WallPair[4]; // создаем массив из 4-х данных объектов
        betweenDistance = 250;
        // теперь инициализуем все элементы массива
        int startPosX = 400; // (_47_) создаем дополнительную перенную чтобы расположить 4 трубы
        // startPosX - начальное положение каждой трубы
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX,0)); // (_46_)
            startPosX += 220; // (_48_) меняем положение
        }

    }

    public void render(SpriteBatch batch){ // (_49_) создаем класс с параметром Спрайт Батч
        // здесь будет происходить отрисовка
        for (int i = 0; i < obs.length; i++) { // с помощью цикла
            batch.draw(txt, obs[i].position.x, obs[i].position.y - obs[i].offset);
            // таким образом отрисуются нижние трубы
            batch.draw(txt, obs[i].position.x, obs[i].position.y + betweenDistance + txt.getHeight() - obs[i].offset);
            // (_57_) копируем (_49_) и добавляем растояние и высоту трубы
            // (_60_) добавляем - obs[i].offset
        }
    }

    public void update(){ // (_50_) создаем класс апдейт, в котором вызывает метод апдейт для каждой трубы
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();
        }
        // (_51_) теперь нужно интегрировать это в MyGdxGame
    }

    public void recreate(){ // (_71_)
        int startPosX = 400; // просто обновляем значения для пар труб в этом массиве
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX,0));
            startPosX += 220;
        }
    }
}
