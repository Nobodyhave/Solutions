package leetcode

import java.util.*

/**
 * Created by Aleksandr on 28/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/open-the-lock
 */
class OpenTheLock {
    fun openLock(deadEnds: Array<String>, target: String): Int {
        val deadEndsSet = HashSet(deadEnds.toList())

        val marked = HashSet<String>()
        val queue = ArrayDeque<Step>()
        queue.add(Step("0000", 0))
        marked.add("0000")
        while (queue.isNotEmpty()) {
            val step = queue.pollFirst()
            if (deadEndsSet.contains(step.combination)) continue
            if (target == step.combination) {
                return step.steps
            }

            for (i in 0..3) {
                var chars = step.combination.toCharArray()
                if (chars[i] == '9') chars[i] = '0' else chars[i]++
                var s = String(chars)
                if (!marked.contains(s)) {
                    queue.add(Step(s, step.steps + 1))
                    marked.add(s)
                }

                chars = step.combination.toCharArray()
                if (chars[i] == '0') chars[i] = '9' else chars[i]--
                s = String(chars)
                if (!marked.contains(s)) {
                    queue.add(Step(String(chars), step.steps + 1))
                    marked.add(String(chars))
                }
            }
        }

        return -1
    }

    class Step(val combination: String, val steps: Int) : Comparable<Step> {
        override fun compareTo(other: Step): Int {
            return steps.compareTo(other.steps)
        }

    }
}