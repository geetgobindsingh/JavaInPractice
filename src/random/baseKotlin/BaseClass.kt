package random.baseKotlin

abstract class BaseClass {
    companion object {
        fun printIt(baseClass: BaseClass) {
            if (baseClass is ChildClass) {
                System.out.print(baseClass.myProperty)
            }
        }
    }
}