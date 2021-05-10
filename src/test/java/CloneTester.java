import linkedLists.DLDHDTList;
import linkedLists.SLFLList;
import linkedLists.SLList;

/**
 * @author frenzy
 */
public class CloneTester {
    public static void main(String[] args) throws CloneNotSupportedException {
        SLList<Integer> SLList = new SLList<>();
        SLList<Integer> cloneSLList = (linkedLists.SLList<Integer>) SLList.clone();

        SLFLList<Integer> SLFLList = new SLFLList<>();
        SLFLList<Integer> cloneSLFLList = (linkedLists.SLFLList<Integer>) SLFLList.clone();

        DLDHDTList<Integer> DLDHDTList = new DLDHDTList<>();
        DLDHDTList<Integer> cloneDLDHDTList = (linkedLists.DLDHDTList<Integer>) DLDHDTList.clone();
        // If nothing blows up here then its working
    }
}
