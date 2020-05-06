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