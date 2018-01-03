package leetcode

/**
 * Created by Aleksandr on 02/01/2018.
 * Project Solutions
 *
 * https://leetcode.com/problems/pyramid-transition-matrix
 */
class PyramidTransitionMatrix {
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        return dfs(bottom, "", HashSet(allowed), 0)
    }

    private fun dfs(prev: String, cur: String, allowed: HashSet<String>, start: Int): Boolean {
        if (prev.length == 1) {
            return true
        }

        for (c in 'A'..'G') {
            val s = prev.substring(start, start + 2) + c
            var isDone = false
            if (allowed.contains(s)) {
                isDone = if (start != prev.length - 2) {
                    dfs(prev, cur + c, allowed, start + 1)
                } else {
                    dfs(cur + c, "", allowed, 0)
                }
            }

            if (isDone) {
                return true
            }
        }

        return false
    }
}