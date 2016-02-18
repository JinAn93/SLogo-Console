#Cell Society Team 2 API Exercise
=======

###API Critique
**Critique of Cell Society Team 24**

######Cell class
> - public Color getColor() - Internal API
> - public void setColor(Color c) - External API
> - public int getX() - External API
> - public int getY() - External API

######RuleEnforcer class
> - public ArrayList<Cell> getNeighbors(Cell check, boolean wrap) - Internal API
> - public int wrapCor(int cor) - Internal API
> - public ArrayList<Cell> getAdjNeighbors(Cell check, boolean wrap) - Internal API
> - public void createCopyGrid() - Internal API

######FileErrorCheck class
> - public void validateSim() - Internal API
> - public void fillParam() - Internal API
> - public void validateParams() - Internal API

######FileReader Class
> - public FileReader(File f) throws SAXException, IOException, ParserConfigurationException - External API
> - public void validateSim() - External API
> - public String readProperty(String property) - External API 
> - public int[] populateCoorArray(String vals) - External API  

######Gridinitializer class
> - public abstract void makeGrid() - Internal API

######Simulator class
> - public void step() - External API
> - public void start() - External API
> - public void adjustSpeed(double ratio) - External API
> - public void stop() - External API
> - public void resume() - External API
> - public void byStep() - External API


