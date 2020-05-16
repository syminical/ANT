//  Copyright (C) 2020 Alexandru Manaila.

/*  This file is part of A.N.T.

    A.N.T. is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    A.N.T. is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with A.N.T.  If not, see <https://www.gnu.org/licenses/>.
*/

package syminical.ant_gui;

import java.awt.Image;

public class ImageList {
   private PicNode Head, Last, Next;
   private int size, itr;
   
   public ImageList() { Head = null; Last = null; Next = null; size = 0; itr = 0; }
   
   public void add(Image __) {      
      if (Head == null) {
         Head = new PicNode(__);
         Last = Head; Next = Head;
      } else
         Last = Last.Next(new PicNode(__));
      ++size;
   }
   
   public Image next() {
      if (itr < size) {
         if (itr != 0) Next = Next.Next();
         ++itr;
         return Next.Data();
      } else return null;
   }
   
   public Image[] next(int n) {
      if (itr + n - 1 < size) {
         Image[] Ret = new Image[n];
         for (int i = 0; i < n; ++i) {
            Ret[i] = this.next();
         }
         return Ret;
      } else return null;
   }
   
   private class PicNode {
      private PicNode Next;
      private Image Data;
      
      public PicNode(Image __) {
         super();
         Data = __;
      }
      
      public PicNode Next(PicNode __) { Next = __; return __; }
      public PicNode Next() { return Next; }
      public Image Data() { return Data; }
   }
}