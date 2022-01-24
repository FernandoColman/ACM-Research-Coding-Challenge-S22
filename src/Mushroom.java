public class Mushroom {
    char poisonous;
    char capShape;
    char capSurface;
    char capColor;
    char bruises;
    char odor;
    char gillAttach;
    char gillSpace;
    char gillSize;
    char gillColor;
    char stalkShape;
    char stalkRoot;
    char stalkSurfaceAbove;
    char stalkSurfaceBelow;
    char stalkColorAbove;
    char stalkColorBelow;
    char veilType;
    char veilColor;
    char ringNum;
    char ringType;
    char sporePrint;
    char population;
    char habitat;

    public Mushroom(String[] givenDetails) {
        poisonous = givenDetails[0].charAt(0);
        capShape = givenDetails[1].charAt(0);
        capSurface = givenDetails[2].charAt(0);
        capColor = givenDetails[3].charAt(0);
        bruises = givenDetails[4].charAt(0);
        odor = givenDetails[5].charAt(0);
        gillAttach = givenDetails[6].charAt(0);
        gillSpace = givenDetails[7].charAt(0);
        gillSize = givenDetails[8].charAt(0);
        gillColor = givenDetails[9].charAt(0);
        stalkShape = givenDetails[10].charAt(0);
        stalkRoot = givenDetails[11].charAt(0);
        stalkSurfaceAbove = givenDetails[12].charAt(0);
        stalkSurfaceBelow = givenDetails[13].charAt(0);
        stalkColorAbove = givenDetails[14].charAt(0);
        stalkColorBelow = givenDetails[15].charAt(0);
        veilType = givenDetails[16].charAt(0);
        veilColor = givenDetails[17].charAt(0);
        ringNum = givenDetails[18].charAt(0);
        ringType = givenDetails[19].charAt(0);
        sporePrint = givenDetails[20].charAt(0);
        population = givenDetails[21].charAt(0);
        habitat = givenDetails[22].charAt(0);
    }

    public void printAllDetails() {
        System.out.println(this.getPoisonous() + " " + this.getCapShape() + " " + this.getCapSurface() + " " + this.getCapColor() + " " + this.getBruises() + " " +  this.getOdor() + " " + this.getGillAttach() + " "
                + this.getGillSpace() + " " + this.getGillSize() + " " + this.getGillColor() + " " + this.getStalkShape() + " " + this.getStalkRoot() + " " + this.getStalkSurfaceAbove() + " " + this.getStalkSurfaceBelow() + " "
                + this.getStalkColorAbove() + " " + this.getStalkColorBelow() + " " + this.getVeilType() + " " + this.getVeilColor() + " " + this.getRingNum() + " " + this.getRingType() + " " + this.getSporePrint() + " "
                + this.getPopulation() + " " + this.getHabitat());
    }

    public char getPoisonous() {
        return poisonous;
    }

    public char getCapShape() {
        return capShape;
    }

    public char getCapSurface() {
        return capSurface;
    }

    public char getCapColor() {
        return capColor;
    }

    public char getBruises() {
        return bruises;
    }

    public char getOdor() {
        return odor;
    }

    public char getGillAttach() {
        return gillAttach;
    }

    public char getGillSpace() {
        return gillSpace;
    }

    public char getGillSize() {
        return gillSize;
    }

    public char getGillColor() {
        return gillColor;
    }

    public char getStalkShape() {
        return stalkShape;
    }

    public char getStalkRoot() {
        return stalkRoot;
    }

    public char getStalkSurfaceAbove() {
        return stalkSurfaceAbove;
    }

    public char getStalkSurfaceBelow() {
        return stalkSurfaceBelow;
    }

    public char getStalkColorAbove() {
        return stalkColorAbove;
    }

    public char getStalkColorBelow() {
        return stalkColorBelow;
    }

    public char getVeilType() {
        return veilType;
    }

    public char getVeilColor() {
        return veilColor;
    }

    public char getRingNum() {
        return ringNum;
    }

    public char getRingType() {
        return ringType;
    }

    public char getSporePrint() {
        return sporePrint;
    }

    public char getPopulation() {
        return population;
    }


    public char getHabitat() {
        return habitat;
    }


}
