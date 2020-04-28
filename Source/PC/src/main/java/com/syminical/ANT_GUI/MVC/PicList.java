package syminical.ant_gui;

public class PicList {
   private PicNode Head, Next;
   private int size, itr;
   
   public PicList() { Head = null; Next = null; size = 0; itr = 0; }
   
   public void add(Image __) {
      if (Head == null) {
         Head = new PicNode(__);
         Next = Head;
      } else
         Head.Next(new PicNode(__));
      ++size;
   }
   
   public Image next() {
      if (itr < size) {
         if (itr == 0)
         else Next = Next.Next();
         ++itr;
         return Next;
      } else return null;
   }
 
   private class PicNode {
      private PicNode Next;
      private Image Data;
      
      public PicNode(Image __) {
         super();
         Data = __;
      }
      
      public Next(PicNode __) { Next = __; }
      public PicNode Next() { return Next; }
      public Image Data() { return Data; }
   }
}