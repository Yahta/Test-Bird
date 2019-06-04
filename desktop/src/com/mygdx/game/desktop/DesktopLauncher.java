package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher { // класс, который запускает десктопное приложение
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// конфигурационный объект, с помощью которого можно менять разрешение игры
		config.width = 800; // (_18_) меняем разрешение игры, ширину
		config.height = 600; // и также создаем высоту. Возвращаемся в Java Class Background
		new LwjglApplication(new MyGdxGame(), config);
	}
}
