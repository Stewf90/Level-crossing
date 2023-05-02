Light topLeft = new Light();
Light topRight  = new Light();
Light bottom = new Light();

        // create a level crossing light system
LevelCrossingController lcc = new LevelCrossingController(topLeft, topRight, bottom);
lcc.doTrainApproaching();
