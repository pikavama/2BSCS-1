import java.util.*;
import java.io.*;

public class BlockSectionDA{
    private List<BlockSection> blockSectionList;

    //setters getters
    public List<BlockSection> getBlockSectionList(){
        return blockSectionList;
    }

    //constructor = set initial actions of an object
    public BlockSectionDA() throws FileNotFoundException{
        blockSectionList = new ArrayList<>();

        //to read the blocksection csv
        Scanner blockFile = new Scanner (new FileReader("BlockFile.csv"));
        
        //this LOOP will read until meron pang laman
        while(blockFile.hasNext()){
            BlockSection blockSection = new BlockSection();
            
            String blockSectionRaw = blockFile.nextLine();
            String[] blockSectionArray = new String[2];
            blockSectionArray = blockSectionRaw.split(", ");

            //set value for blockSection object
            blockSection.setBlockCode(blockSectionArray[0].trim());
            blockSection.setAdviser(blockSectionArray[1].trim());

            StudentDA studentDA = new StudentDA(blockSection.getBlockCode());
            blockSection.setStudentList(studentDA.getStudentList());

            
            blockSectionList.add(blockSection);
        }
        blockFile.close();
    }
}

/*NOTES:
 * split = will split the string of an array
 * trim = 
 */