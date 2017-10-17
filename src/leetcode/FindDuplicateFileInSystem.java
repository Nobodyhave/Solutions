package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksandr on 16/10/2017.
 * Project Solutions
 */
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        if (paths == null || paths.length == 0) {
            return new ArrayList<>();
        }

        final Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            final String[] folderPaths = paths[i].split(" ");
            final String folderPath = folderPaths[0] + "/";
            for (int j = 1; j < folderPaths.length; j++) {
                final int openBracketIndex = folderPaths[j].indexOf("(");
                final String fileName = folderPaths[j].substring(0, openBracketIndex);
                final String content = folderPaths[j].substring(openBracketIndex + 1, folderPaths[j].length() - 1);

                map.computeIfAbsent(content, key -> new ArrayList<>());
                map.get(content).add(folderPath + fileName);
            }
        }

        final List<List<String>> result = new ArrayList<>();
        for (List<String> p : map.values()) {
            if (p.size() > 1) {
                result.add(p);
            }
        }

        return result;
    }
}
