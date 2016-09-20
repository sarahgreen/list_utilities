/**********************************************
 * ListSetTest.java
 * @author SarahGreen
 *********************************************/

package list_utilities;

/**
 * The {@link ListSetTest} class is a tester class for the classes in the
 * ListUtilities package. It first creates an {@link ImmutableList} using the
 * command line arguments, then purges, mergesorts, and prints it. Then it
 * creates a {@link ListSet} using the command line arguments, and prints it.
 * 
 * The class then prints various statements showing that the methods from the
 * {@link ListSet} class work correctly.
 */
public class ListSetTest {

	public static void main(String[] args) {

		/**
		 * Creates and tests an {@link ImmutableList} and a {@link ListSet} from
		 * the command line arguments.
		 */
		String s = "";
		for (int i = 0; i < args.length - 1; i++)
			s += args[i] + " ";
		ImmutableList immListTest = ImmutableList.parseIntList(s).reverse();
		immListTest = immListTest.purge().mergesort();
		ImmutableList setTest = ImmutableList.parseIntList(s).reverse().purge();
		ListSet listSetTest = new ListSet(setTest);

		/**
		 * Prints the results of testing the {@link ImmutableList} and
		 * {@link ListSet}.
		 */
		IO.stdout.println();
		IO.stdout.println("~~~REQUIRED OUTPUT~~~");
		IO.stdout.println("Immutable list is: " + immListTest);
		IO.stdout.println("Set is: " + listSetTest);

		/** Additional tester code for the methods in {@link ListSet}. */
		IO.stdout.println();
		IO.stdout.println("~~~ADDITIONAL OUTPUT~~~");
		IO.stdout.println("Get list underlying the Set: "
				+ listSetTest.getList());
		IO.stdout.println("Size of Set: " + listSetTest.size());
		IO.stdout.println("Is the Set empty? " + listSetTest.isEmpty());
		IO.stdout.println("Is 4 a member of the Set? "
				+ listSetTest.isMember(4));
		IO.stdout.println("Is 48 a member of the Set? "
				+ listSetTest.isMember(48));
		IO.stdout.println("Copy of the Set: " + listSetTest.copy());
		String otherString = "5 10 4 3 7";
		ImmutableList otherList = ImmutableList.parseIntList(otherString);
		ListSet otherSetTest = new ListSet(otherList);
		IO.stdout.println("Union with Set " + otherSetTest + ": "
				+ listSetTest.union(otherSetTest));
		IO.stdout.println("Intersection with Set " + otherSetTest + ": "
				+ listSetTest.intersection(otherSetTest));
		listSetTest.add(10);
		IO.stdout.println("Add 10 to the Set: " + listSetTest);
		listSetTest.remove(7);
		IO.stdout.println("Remove 7 from the Set: " + listSetTest);
		IO.stdout.println("Set has next? " + listSetTest.hasNext());
		IO.stdout.println("Set next: " + listSetTest.next());
		IO.stdout.println("Empty Set: " + listSetTest.empty());
		IO.stdout.println("Is the Set empty? " + listSetTest.empty().isEmpty());
		IO.stdout.println();
	}
}
