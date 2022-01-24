import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        ArrayList<Mushroom> poisonousMushrooms = new ArrayList<>();
        ArrayList<Mushroom> edibleMushrooms = new ArrayList<>();
        ArrayList<Mushroom> mushrooms = new ArrayList<>();
        int lineCount = 0;

        try {
            // Read CSV into BufferedReader
            BufferedReader csv = new BufferedReader(new FileReader("mushrooms.csv"));
            String everyLine;

            // Keep Reading Lines until reach End-Of-File Character
            while((everyLine = csv.readLine()) != null) {

                //Ignore first Line of categories
                if(lineCount++ == 0)
                   continue;

                //Split each Line into a String[] then create Mushroom Object with String[]
                // Add Mushroom object to Mushrooms ArrayList
                String[] oneMushroom = everyLine.split(",");
                Mushroom newMushroom = new Mushroom(oneMushroom);
                mushrooms.add(newMushroom);

                // separate Mushrooms based on class
                if(newMushroom.getPoisonous() == 'p')
                    poisonousMushrooms.add(newMushroom);
                else if(newMushroom.getPoisonous() == 'e')
                    edibleMushrooms.add(newMushroom);
            }
        }
        catch(IOException excp) {
            System.out.println("oops");
            excp.printStackTrace();
        }

        // Menu for User Interface
        Scanner kb = new Scanner(System.in);
        int selection;
        while(true) {
            System.out.println("(0) - Show Mushroom Characteristics Legend");
            System.out.println("(1) - Display List of Poisonous Mushrooms");
            System.out.println("(2) - Display List of Edible Mushrooms");
            System.out.println("(3) - Enter Mushroom Characteristics and Check for Poisonous/Edible");
            System.out.println("(4) - Exit Program");
            System.out.print("Enter a selection: ");
            selection = kb.nextInt();

            if(selection == 0)
                displayLegend();
            else if (selection == 1)
                displayMushrooms(poisonousMushrooms);
            else if (selection == 2)
                displayMushrooms(edibleMushrooms);
            else if (selection == 3) {
                Mushroom idealMushroom = askDetails();
                findIfMushroomPoisonous(mushrooms, idealMushroom);
            }
            else if (selection == 4)
                break;
            else
                System.out.println("Please enter a valid selection.\n");

        }

    }

    // Input: None
    // Output: Prints a Legend describing the symbols Mushroom categorization
    public static void displayLegend() {
        System.out.println("\nclasses: edible=e, poisonous=p");
        System.out.println("cap-shape: bell=b, conical=c, convex=x, flat=f, knobbed=k, sunken=s");
        System.out.println("cap-surface: fibrous=f, grooves=g, scaly=y, smooth=s");
        System.out.println("cap-color: brown=n, buff=b, cinnamon=c, gray=g, green=r, pink=p, purple=u, red=e, white=w, yellow=y");
        System.out.println("bruises: bruises=t, no=f");
        System.out.println("odor: almond=a, anise=l, creosote=c, fishy=y, foul=f, musty=m, none=n, pungent=p, spicy=s");
        System.out.println("gill-attachment: attached=a, descending=d, free=f, notched=n");
        System.out.println("gill-spacing: close=c, crowded=w, distant=d");
        System.out.println("gill-size: broad=b, narrow=n");
        System.out.println("gill-color: black=k, brown=n, buff=b, chocolate=h, gray=g, green=r, orange=o, pink=p, purple=u, red=e, white=w, yellow=y");
        System.out.println("stalk-shape: enlarging=e, tapering=t");
        System.out.println("stalk-root: bulbous=b, club=c, cup=u, equal=e, rhizomorphs=z, rooted=r, missing=?");
        System.out.println("stalk-surface-above-ring: fibrous=f, scaly=y, silky=k, smooth=s");
        System.out.println("stalk-surface-below-ring: fibrous=f, scaly=y, silky=k, smooth=s");
        System.out.println("stalk-color-above-ring: brown=n, buff=b, cinnamon=c, gray=g, orange=o, pink=p, red=e, white=w, yellow=y");
        System.out.println("stalk-color-below-ring: brown=n, buff=b, cinnamon=c, gray=g, orange=o, pink=p, red=e, white=w, yellow=y");
        System.out.println("veil-type: partial=p, universal=u");
        System.out.println("veil-color: brown=n, orange=o, white=w, yellow=y");
        System.out.println("ring-number: none=n, one=o, two=t");
        System.out.println("ring-type: cobwebby=c, evanescent=e, flaring=f, large=l, none=n, pendant=p, sheathing=s, zone=z");
        System.out.println("spore-print-color: black=k, brown=n, buff=b, chocolate=h, green=r, orange=o, purple=u, white=w, yellow=y");
        System.out.println("population: abundant=a, clustered=c, numerous=n, scattered=s, several=v, solitary=y");
        System.out.println("habitat: grasses=g, leaves=l, meadows=m, paths=p, urban=u, waste=w, woods=d\n\n");
    }

    // Input: ArrayList of Mushroom Objects
    // Output: Prints Details of every Mushroom in the ArrayList
    public static void displayMushrooms(ArrayList<Mushroom> mushrooms) {
        System.out.println("\n");
        for(Mushroom m:mushrooms) {
            m.printAllDetails();

        }
        System.out.println("\n\n");
    }

    // Input: None
    // Output: Prompts User for Mushroom Characteristics Based on Legend and returns an IdealMushroom created based on input
    public static Mushroom askDetails() {
        Scanner kb = new Scanner(System.in);
        String[] details = new String[23];

        System.out.println("\nPlease enter details about your mushroom (Enter '?' else if not sure)");

        System.out.println("classes: edible=e, poisonous=p");
        System.out.print("Class: ");
        details[0] = kb.next();

        System.out.println("cap-shape: bell=b, conical=c, convex=x, flat=f, knobbed=k, sunken=s");
        System.out.print("Cap-Shape: ");
        details[1] = kb.next();

        System.out.println("cap-surface: fibrous=f, grooves=g, scaly=y, smooth=s");
        System.out.print("Cap-Surface: ");
        details[2] = kb.next();

        System.out.println("cap-color: brown=n, buff=b, cinnamon=c, gray=g, green=r, pink=p, purple=u, red=e, white=w, yellow=y");
        System.out.print("Cap-Color: ");
        details[3] = kb.next();

        System.out.println("bruises: bruises=t, no=f");
        System.out.print("Bruises: ");
        details[4] = kb.next();

        System.out.println("odor: almond=a, anise=l, creosote=c, fishy=y, foul=f, musty=m, none=n, pungent=p, spicy=s");
        System.out.print("Odor: ");
        details[5] = kb.next();

        System.out.println("gill-attachment: attached=a, descending=d, free=f, notched=n");
        System.out.print("Gill-Attachment: ");
        details[6] = kb.next();

        System.out.println("gill-spacing: close=c, crowded=w, distant=d");
        System.out.print("Gill-Space: ");
        details[7] = kb.next();

        System.out.println("gill-size: broad=b, narrow=n");
        System.out.print("Gill-Size: ");
        details[8] = kb.next();

        System.out.println("gill-color: black=k, brown=n, buff=b, chocolate=h, gray=g, green=r, orange=o, pink=p, purple=u, red=e, white=w, yellow=y");
        System.out.print("Gill-Color: ");
        details[9] = kb.next();

        System.out.println("stalk-shape: enlarging=e, tapering=t");
        System.out.print("Stalk-Shape: ");
        details[10] = kb.next();

        System.out.println("stalk-root: bulbous=b, club=c, cup=u, equal=e, rhizomorphs=z, rooted=r, missing=?");
        System.out.print("Stalk-Root: ");
        details[11] = kb.next();

        System.out.println("stalk-surface-above-ring: fibrous=f, scaly=y, silky=k, smooth=s");
        System.out.print("Stalk-Surface-Above-Ring: ");
        details[12] = kb.next();

        System.out.println("stalk-surface-below-ring: fibrous=f, scaly=y, silky=k, smooth=s");
        System.out.print("Stalk-Surface-Below-Ring: ");
        details[13] = kb.next();

        System.out.println("stalk-color-above-ring: brown=n, buff=b, cinnamon=c, gray=g, orange=o, pink=p, red=e, white=w, yellow=y");
        System.out.print("Stalk-Color-Above-Ring: ");
        details[14] = kb.next();

        System.out.println("stalk-color-below-ring: brown=n, buff=b, cinnamon=c, gray=g, orange=o, pink=p, red=e, white=w, yellow=y");
        System.out.print("Stalk-Color-Below-Ring: ");
        details[15] = kb.next();


        System.out.println("veil-type: partial=p, universal=u");
        System.out.print("Veil-Type: ");
        details[16] = kb.next();

        System.out.println("veil-color: brown=n, orange=o, white=w, yellow=y");
        System.out.print("Veil-Color: ");
        details[17] = kb.next();

        System.out.println("ring-number: none=n, one=o, two=t");
        System.out.print("Ring-Number: ");
        details[18] = kb.next();

        System.out.println("ring-type: cobwebby=c, evanescent=e, flaring=f, large=l, none=n, pendant=p, sheathing=s, zone=z");
        System.out.print("Ring-Type: ");
        details[19] = kb.next();

        System.out.println("spore-print-color: black=k, brown=n, buff=b, chocolate=h, green=r, orange=o, purple=u, white=w, yellow=y");
        System.out.print("Spore-Print-Color: ");
        details[20] = kb.next();

        System.out.println("population: abundant=a, clustered=c, numerous=n, scattered=s, several=v, solitary=y");
        System.out.print("Population: ");
        details[21] = kb.next();

        System.out.println("habitat: grasses=g, leaves=l, meadows=m, paths=p, urban=u, waste=w, woods=d");
        System.out.print("Habitat: ");
        details[22] = kb.next();

        return new Mushroom(details);
    }

    // Input: ArrayList of all Mushrooms and an idealMushroom object
    // Output: Whether the idealMushroom is poisonous/edible based on mushroom ArrayList

    // Note: This method is meant to be used when the user doesn't want to find their particular mushroom in the large list provided.
    // Instead, the user will enter the characteristics of their mushroom and the function will return whether the given Mushroom is Poisonous/Edible based on its characteristics
    // The User need not enter details for every category. The function will return poisonous as long as the enough characteristics are provided to prove if the mushroom is poisonous.
    public static void findIfMushroomPoisonous(ArrayList<Mushroom> mushrooms, Mushroom idealMushroom) {

        if(idealMushroom.getPoisonous() == 'p') {
            System.out.println("A mushroom with the given properties will be poisonous.");
            return;
        } else if(idealMushroom.getPoisonous() == 'e') {
            System.out.println("A mushroom with the given properties will be edible.");
            return;
        }

        for(int row = 0; row < mushrooms.size(); row++) {
            if(mushrooms.get(row).getCapShape() != idealMushroom.getCapShape() && idealMushroom.getCapShape() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getCapSurface() != idealMushroom.getCapSurface() && idealMushroom.getCapSurface() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getCapColor() != idealMushroom.getCapColor() && idealMushroom.getCapColor() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getBruises() != idealMushroom.getBruises() && idealMushroom.getBruises() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getOdor() != idealMushroom.getOdor() && idealMushroom.getOdor() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getGillAttach() != idealMushroom.getGillAttach() && idealMushroom.getGillAttach() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getGillSpace() != idealMushroom.getGillSpace() && idealMushroom.getGillSpace() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getGillSize() != idealMushroom.getGillSize() && idealMushroom.getGillSize() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getGillColor() != idealMushroom.getGillColor() && idealMushroom.getGillColor() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getStalkShape() != idealMushroom.getStalkShape() && idealMushroom.getStalkShape() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getStalkRoot() != idealMushroom.getStalkRoot() && idealMushroom.getStalkRoot() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getStalkSurfaceAbove() != idealMushroom.getStalkSurfaceAbove() && idealMushroom.getStalkSurfaceAbove() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getStalkSurfaceBelow() != idealMushroom.getStalkSurfaceBelow() && idealMushroom.getStalkSurfaceBelow() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getStalkColorAbove() != idealMushroom.getStalkColorAbove() && idealMushroom.getStalkColorAbove() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getStalkColorBelow() != idealMushroom.getStalkColorBelow() && idealMushroom.getStalkColorBelow() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getVeilType() != idealMushroom.getVeilType() && idealMushroom.getVeilType() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getVeilColor() != idealMushroom.getVeilColor() && idealMushroom.getVeilColor() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getRingNum() != idealMushroom.getRingNum() && idealMushroom.getRingNum() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getRingType() != idealMushroom.getRingType() && idealMushroom.getRingType() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getSporePrint() != idealMushroom.getSporePrint() && idealMushroom.getSporePrint() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getPopulation() != idealMushroom.getPopulation() && idealMushroom.getPopulation() != '?')
                mushrooms.remove(row--);

            else if(mushrooms.get(row).getHabitat() != idealMushroom.getHabitat() && idealMushroom.getHabitat() != '?')
                mushrooms.remove(row--);



        }


        if(mushrooms.size() > 0)
            System.out.println("A mushroom with the given properties will be poisonous.\n\n");
        else
            System.out.println("A mushroom with the given properties will be edible\n\n");


    }
}


