class Solution {
    fun solution(myString: String) = myString.split("x").filterNot(String::isEmpty).sorted()
}