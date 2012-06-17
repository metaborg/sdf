package trans;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class documentation_comment_chars_0_0 extends Strategy 
{ 
  public static documentation_comment_chars_0_0 instance = new documentation_comment_chars_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("documentation_comment_chars_0_0");
    Fail1898:
    { 
      IStrategoTerm u_32999 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1898;
      IStrategoTerm arg797 = ((IStrategoList)term).head();
      if(arg797.getTermType() != IStrategoTerm.INT || 42 != ((IStrategoInt)arg797).intValue())
        break Fail1898;
      u_32999 = ((IStrategoList)term).tail();
      term = ltrim_1_0.instance.invoke(context, u_32999, lifted542.instance);
      if(term == null)
        break Fail1898;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}