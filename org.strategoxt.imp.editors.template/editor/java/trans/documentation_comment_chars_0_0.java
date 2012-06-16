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
    Fail57:
    { 
      IStrategoTerm h_10714 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail57;
      IStrategoTerm arg13 = ((IStrategoList)term).head();
      if(arg13.getTermType() != IStrategoTerm.INT || 42 != ((IStrategoInt)arg13).intValue())
        break Fail57;
      h_10714 = ((IStrategoList)term).tail();
      term = ltrim_1_0.instance.invoke(context, h_10714, lifted12.instance);
      if(term == null)
        break Fail57;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}