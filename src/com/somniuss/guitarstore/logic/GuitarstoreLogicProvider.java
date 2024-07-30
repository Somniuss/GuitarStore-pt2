package com.somniuss.guitarstore.logic;

import com.somniuss.guitarstore.logic.impl.*;

public final class GuitarstoreLogicProvider {

	private static final GuitarstoreLogicProvider instance = new GuitarstoreLogicProvider();

	private GuitarstoreLogicProvider() {}

	private GuitarstoreLogic logic = new GuitarstoreLogicImpl();

	public GuitarstoreLogic getGuitarstoreLogic() {
		return logic;
	}

	public static GuitarstoreLogicProvider getInstance() {
		return instance;
	}

}
