package hackerrank.preparationkit.stacks_and_queues;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://www.hackerrank.com/challenges/min-max-riddle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
public class MinMaxRiddle {
  // Complete the riddle function below.
  static class Area {
    public int i;
    public long v;

    public Area(int i, long v) {
      this.i = i;
      this.v = v;
    }
  }

  static long[] riddle(long[] arr) {
    // complete this function
    Map<Long, Integer> coverage = new HashMap<>();
    Stack<Area> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (stack.isEmpty() || stack.peek().v <= arr[i]) {
        stack.add(new Area(i, arr[i]));
      } else {
        int prevIndex = -1;
        while (!stack.isEmpty() && stack.peek().v > arr[i]) {
          Area finishedArea = stack.pop();
          int previousCoverage = coverage.getOrDefault(finishedArea.v, 0);
          int currentCoverage = i - finishedArea.i;
          coverage.put(finishedArea.v, Math.max(previousCoverage, currentCoverage));
          prevIndex = finishedArea.i;
        }
        stack.add(new Area(prevIndex, arr[i]));
      }
    }
    while (!stack.isEmpty()) {
      Area finishedArea = stack.pop();
      int previousCoverage = coverage.getOrDefault(finishedArea.v, 0);
      int currentCoverage = arr.length - finishedArea.i;
      coverage.put(finishedArea.v, Math.max(previousCoverage, currentCoverage));
    }
    Map<Integer, Long> maxInZones = new HashMap<>();
    coverage.forEach((value, zone) -> {
      if (!maxInZones.containsKey(zone)) {
       maxInZones.put(zone, value);
      } else {
        maxInZones.put(zone, Math.max(maxInZones.get(zone), value));
      }
    });
    long[] answer = new long[arr.length];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = -1L;
    }
    maxInZones.forEach((zone, max) -> {
      answer[zone-1] = max;
    });
    for (int i = answer.length-2; i >=0; i--) {
      if (answer[i] == -1) {
        answer[i] = answer[i+1];
      }
      if (answer[i] < answer[i+1]) {
        answer[i] = answer[i+1];
      }
    }
    return answer;
  }

  @Test
  void run() {
    long[] in1 = {3,5,4,7,6,2};
    System.out.println("answer: " + Arrays.toString(riddle(in2)));
  }

  static long[] in2 = {
      894059773,675064454,766421039,183804740,272974047,318194207,796467272,599168674,919109084,204797163,56228018,552520820,842849403,616362851,37312720,447356912,297292879,771454052,917766476,518006057,102858325,63108402,427151841,923058132,863670730,915203352,114510793,185323012,337816875,235484693,720229272,295420078,920480415,409792010,96481372,844770861,333773382,803453647,989088845,994124828,982460315,291934617,116326938,141807605,87343853,61793254,736141408,456307524,926320795,157666054,39021763,641364916,580916803,69301641,566817912,765267632,805798071,247296134,767662384,654521994,947278525,682571339,343939364,264009444,408838539,60025859,79650871,434273506,150436591,453357282,625688135,710801851,500705029,9558743,799843801,449450109,790814906,574791471,421196586,957902837,361259174,218758579,116404064,50868182,341974529,622830856,951805413,765028295,986674945,591922994,41621080,236320336,952581487,867980258,759094634,190758500,79824507,368359526,499035193,879555698,241051670,455572992,121389583,193529635,701515460,53534166,479035242,937791387,956368783,724142588,563317008,899334122,465361113,880752482,342852924,817683442,812643246,18868753,330313869,814211183,54002285,171882536,576313784,450162658,643600399,506431893,182804366,427654373,188055367,764430926,169812165,678712314,158344134,502368260,310976870,643996852,459459043,828941351,634824028,440250825,906860903,503384703,67698043,493582906,9337359,625827651,194572098,966203132,623407686,75087081,274479388,681756400,746037275,722405489,513605319,454198570,32557751,637624310,369068878,145414987,718213688,56465290,982153357,785483564,889455988,490390339,622655997,111835183,944959624,854108729,585298682,512069846,638522948,917240977,827120143,501863982,218513629,222000288,925738306,242494938,928088775,165753794,825730988,828239401,839982205,997383085,936927297,941942658,188866948,13826616,55766913,234582227,381265665,604770240,898572062,386240982,300121305,708673,58077199,206862163,504446066,249811601,251527924,906043711,97321326,374091863,976931470,658009566,329098687,428840145,983877979,392497889,283280511,327840941,454655441,39350534,100869308,746083306,837045856,785094438,928356407,717961510,55220499,12351142,33138426,131874500,909749754,766156097,90731954,311049352,821410726,174983228,327321205,490340902,852139050,557118157,815517833,658503027,301710520,163002038,285995063,590556140,856240435,185211602,800663577,889027207,183924593,684323468,165274973,723618800,426771362,812940540,627654269,406692436,663536286,384745717,283177955,582460055,101484984,183435756,983434360,926611306,678845272,161119564,623410669,724891222,498160707,87068041,99032865,914896943,236154867,52030517,555581611,923633033,251640651,21016508,903653134,994970214,487955261,733042111,941457385,599526078,134534125,374702357,712551150,462096640,943351055,352677868,633834889,518420561,20826611,331626496,178071289,963464437,470234374,493238081,456243014,484489789,179094337,864167061,703787743,970385136,766613225,378514501,820209128
  };
}
