package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch; // область адресов, используется для адресовки и управления объекта
	// (_14_)удаляем имедж присвоение картинки бедлоджик за ненадобностью,
	//Texture img; // поле класса текструра, просто картинка, которая загружается в память и используется
	Background bg = new Background(); // (_13_) удаляем метод текстур за ненадобностью.
	// Создаем инициализацию фона игры
	Bird bird; // (_35_)
	Obstacles obstacles; // (_52_) создаем это поле в методе
	boolean gameOver; // (_65_) пишем новое поле
	Texture restartTexture; //

	@Override
	public void create () {
		// метод, который запускается единожды,
		// и в котором загружаются в память все необходимые элементы, подготовительные действия,
		// например, первичный математический расчет для игры
		batch = new SpriteBatch(); // партия?
		// img = new Texture("badlogic.jpg"); // метод, с помощью которого загружается картинка
		bird = new Bird(); // (_36_) прописываем в конструкторе
		obstacles = new Obstacles(); // (_53_) добавляем метод
		gameOver = false; // (_66_) пишем конструктор
		restartTexture = new Texture("RestartBtn.png"); //

	}

	@Override
	public void render () {
		// метод, который вызывается 60/секунду,
		// отрисовывает 60 раз в секунду то, что мы зададим в этом методе
		Gdx.gl.glClearColor(1, 1, 1, 1);
		// метод, в котором создаем цвет
		// цвет, с помощью которого заливается поле
		// цвет кодируется
		// альфа канал - это прозрачность
		// (_1_) меняем значения цветов в методе, f - float, значит число с плавающей точкой
		// (_10_) меняем все значения на 1, чтобы был белый фон, потом возвращаемся в Java Class Background
		update();// (_9_) будем вызывать этот метод в рендере каждый раз
		// , чтобы пересчитать математику  для всей игры
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // метод, который заливает цвет в поле
		batch.begin(); // начало отрисовки
		//batch.draw(img, 0, 0); // метод, который отрисовывает заданную картинку,
		// фотрмат img. Координаты это место, откуда метод начинает отрисовывание картинки
		bg.render(batch); // (_15_) удаляем метод батч дроу за ненадобностью,
		// берем экземпляр класса, вызываем метод рендер и как параметр передаем метод батч

		bird.render(batch); // (_37_) отрисовываем после бекграунда, чтобы она отрисовывалась поверх фона
		obstacles.render(batch); // (_54_) вызываем метод рендер этого класса
		if (!gameOver){ // (_66_) если не наступил гейм овер, то продолжает отрисовывать птичку
			bird.render(batch);
		}else{batch.draw(restartTexture, 200, 200); //

		}
		batch.end(); // конец отрисовки
	}

	public void update() { // (_8_) этот метод нужен для просчета математики игры.
		// поскольку картинка будет двигаться фоном, соответсвенно будет меняться её положение
		//в системе координат положений в Деккартовой системе координат
		bg.update(); // (_16_) то же самое проделываем в методе обновления
		bird.update(); // (_38) просчитываем всю математику для позиции
		obstacles.update(); // (_55_) вызываем метод апдейт. затем возвращаемся в Java Class Obstacles
		for (int i = 0; i < Obstacles.obs.length; i++) { // (_67_) запускаем цикл фор,
			// который будет работать до длины массивы состоящего из волпера в классе обстеклс
			if (bird.position.x > Obstacles.obs[i].position.x && bird.position.x < Obstacles.obs[i].position.x + 50) {
				// если позиция птички такова, это значит чт птичка летит между парой труб
			}
			if (!Obstacles.obs[i].emptySpace.contains(bird.position)) { // если она летит между парой труб,
				// если птичка находится в пустой прямоугольнике, она не проигрывает
				// если пустой прямоугольник не содержит  птичку, то мы проиграем
				gameOver = true;
			}
			}//

		if(bird.position.y <0 || bird.position.y > 600){ // (_68_) прописываем дополнительное условие для проигрыша
			gameOver = true;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver){
			// (_69_) обрабатываем ситуацию, когда хотим начать игру заново. Если нажать пробел и случился геймовер.
			// в Java Class Bird и Obstacles добавляем метод рекриейд
			recreate(); // (_74_) просто будем его вызывать

		}

		}


	@Override
	public void dispose () { // метод, который очищает ресурсы, поскольку могут быть разные уровни в игре
		batch.dispose();
		// img.dispose(); (_17_) убираем за ненадобностью. Идем в Java Class DesktopLauncher
	}

	public void recreate(){ // (_73_) создаем метод рекриейт
	bird.recreate();
	obstacles.recreate();
	gameOver = false;
	}


}

// (_3_) создаем новый Java Class  Background в папке com.mygdx.game