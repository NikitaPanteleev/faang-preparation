package google1.preparationkit.recursion_and_backtracking;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Crossword {
  public static class Position {
    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

    public Position(int startRow, int startColumn, int endRow, int endColumn) {
      this.startRow = startRow;
      this.startColumn = startColumn;
      this.endRow = endRow;
      this.endColumn = endColumn;
    }

    public int length() {
      if (startRow == endRow) {
        return endColumn - startColumn + 1;
      }
      return endRow - startRow + 1;
    }

    public HashMap<String, Character> getMap(String word) {
      HashMap<String, Character> answer = new HashMap<>();
      int i = 0;
      int nextIndex = 0;
      for (Character letter : word.toCharArray()) {
        if (startRow == endRow) {
          nextIndex = (startColumn + i);
          answer.put(startRow + ":" + nextIndex, letter);
        } else {
          nextIndex = startRow + i;
          answer.put(nextIndex + ":" + startColumn, letter);
        }
        i++;
      }
      return answer;
    }

    public List<Map.Entry<Character, int[]>> getChars(String word) {
      List<Map.Entry<Character, int[]>> answer = new ArrayList<>();
      int i = 0;
      for (Character letter : word.toCharArray()) {
        if (startRow == endRow) {
          int[] position = {startRow, startColumn + i};
          answer.add(new HashMap.SimpleEntry<>(letter, position));
        } else {
          int[] position = {startRow + i, startColumn};
          answer.add(new HashMap.SimpleEntry<>(letter, position));
        }
        i++;
      }
      return answer;
    }

    @Override
    public String toString() {
      return "Position{" + startRow + ":" + startColumn + "-" + endRow + ":" + endColumn + "}";
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Position position = (Position) o;
      return startRow == position.startRow &&
          startColumn == position.startColumn &&
          endRow == position.endRow &&
          endColumn == position.endColumn;
    }

    @Override
    public int hashCode() {
      return Objects.hash(startRow, startColumn, endRow, endColumn);
    }
  }


  static String[] crosswordPuzzle(String[] crossword, String wordsArrays) {
    Stack<Position> parsedPositions = new Stack<>();
    for (int i = 0; i < crossword.length; i++) {
      parsedPositions.addAll(parseString(crossword[i], i, true));
    }
    for (int i = 0; i < 10; i++) {
      String column = "";
      for (String row : crossword) {
        column += row.charAt(i);
      }
      parsedPositions.addAll(parseString(column, i, false));
    }

    Map<String, Position> solution = new HashMap<>();
    List<String> _words = Arrays.asList(wordsArrays.split(";"));
    Stack<String> words = new Stack<>();
    words.addAll(_words);
    boolean result = fillWords(parsedPositions, words, solution);
    char[][] answerChars = update(crossword, solution);
    String[] answer = new String[10];
    for (int i = 0; i < 10; i++) {
      answer[i] = new String(answerChars[i]);
    }
    return answer;
  }

  public static char[][] update(String[] tmp, Map<String, Position> solution) {
    char[][] strings = new char[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        strings[i][j] = tmp[i].charAt(j);
      }
    }
    for (Map.Entry<String, Position> entry : solution.entrySet()) {
      List<Map.Entry<Character, int[]>> chars = entry.getValue().getChars(entry.getKey());
      for (Map.Entry<Character, int[]> replacement : chars) {
        strings[replacement.getValue()[0]][replacement.getValue()[1]] = replacement.getKey();
      }
    }
    return strings;
  }


  public static boolean fillWords(
      Stack<Position> remainingPositions,
      List<String> allWords,
      Map<String, Position> solution) {
    if (remainingPositions.isEmpty()) {
      // we have to check current solution
      HashMap<String, Character> cells1 = new HashMap<>(10);
      HashMap<String, Character> cells2 = new HashMap<>(10);
      for (Map.Entry<String, Position> entry : solution.entrySet()) {
        cells1 = entry.getValue().getMap(entry.getKey());
        for (Map.Entry<String, Position> entry2 : solution.entrySet()) {
          if (!entry2.getKey().equals(entry.getKey())) {
            cells2 = entry2.getValue().getMap(entry2.getKey());
            for (String key : cells1.keySet()) {
              if (cells2.get(key) != null && !cells2.get(key).equals(cells1.get(key))) {
                return false;
              }
            }
          }
        }
      }
      return true;
    } else {
      Position position = remainingPositions.pop();
      for (String word : allWords) {
        if (!solution.containsKey(word) && word.length() == position.length()) {
          solution.put(word, position);
          boolean result = fillWords(remainingPositions, allWords, solution);
          if (result) {
            return true;
          }
          solution.remove(word);
        }
      }
      remainingPositions.push(position);
      return false;
    }
  }

  public static List<Position> parseString(String s, int index, boolean isHorizontal) {
    ArrayList<Position> positions = new ArrayList<>();
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '-' && len > 1) {
        if (isHorizontal) {
            positions.add(new Position(index, i - len , index, i - 1));
          } else {
            positions.add(new Position(i - len, index, i - 1, index));
          }
        len = 0;
      } else if (s.charAt(i) == '-') {
        len+=1;
      } else if (s.charAt(i) != '-') {
        len = 0;
      }
    }
    if (len > 1) {
      if (isHorizontal) {
        positions.add(new Position(index, s.length() - len , index, s.length() - 1));
      } else {
        positions.add(new Position(s.length() - len, index, s.length() - 1, index));
      }
    }
    return positions;
  }

  @Test
  void run() {
    String[] input = {
        "+-++++++++",
        "+-++++++++",
        "+-++++++++",
        "+-----++++",
        "+-+++-++++",
        "+-+++-++++",
        "+++++-++++",
        "++------++",
        "+++++-++++",
        "+++++-++++"
    };
    String words1 = "LONDON;DELHI;ICELAND;ANKARA";
    String[] input2 = {
        "+-++++++++",
        "+-++++++++",
        "+-------++",
        "+-++++++++",
        "+-++++++++",
        "+------+++",
        "+-+++-++++",
        "+++++-++++",
        "+++++-++++",
        "++++++++++"
    };
    String words2 = "AGRA;NORWAY;ENGLAND;GWALIOR";

    String[] input3 = {
        "XXXXXX-XXX",
        "XX------XX",
        "XXXXXX-XXX",
        "XXXXXX-XXX",
        "XXX------X",
        "XXXXXX-X-X",
        "XXXXXX-X-X",
        "XXXXXXXX-X",
        "XXXXXXXX-X",
        "XXXXXXXX-X"
    };
    String words3 = "ICELAND;MEXICO;PANAMA;ALMATY";
    val result = crosswordPuzzle(input, words1);
    val result2 = crosswordPuzzle(input2, words2);
    val result3 = crosswordPuzzle(input3, words3);
  }
}
