/*
  Copyright 2014-2017 Sylvain Hallé
  Laboratoire d'informatique formelle
  Université du Québec à Chicoutimi, Canada

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package ca.uqac.lif.bullwinkle.examples;

/**
 * A simple class (and descendants) to represent arithmetical
 * expressions. These classes are used by {@link BuildExampleStack} to
 * illustrate the use of the {@link ParseTreeObjectBuilder}.
 * @author Sylvain Hallé
 */
public abstract class ArithExp
{
	public static class Num extends ArithExp
	{
		int n;

		public Num(int n)
		{
			this.n = n;
		}

		@Override
		public String toString()
		{
			return Integer.toString(n);
		}
	}

	public static abstract class BinaryExp extends ArithExp
	{
		ArithExp left;
		ArithExp right;
		String symbol;

		public BinaryExp(ArithExp left, ArithExp right, String symbol)
		{
			this.left = left;
			this.right = right;
			this.symbol = symbol;
		}

		@Override
		public String toString()
		{
			return "(" + left.toString() + ")" + symbol + "(" + right.toString() + ")"; 
		}
	}

	public static class Add extends BinaryExp
	{
		public Add(ArithExp left, ArithExp right) 
		{
			super(left, right, "+");
		}
	}

	public static class Sub extends BinaryExp
	{
		public Sub(ArithExp left, ArithExp right) 
		{
			super(left, right, "-");
		}
	}		
}