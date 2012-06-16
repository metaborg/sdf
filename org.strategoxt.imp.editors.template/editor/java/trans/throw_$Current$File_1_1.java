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

@SuppressWarnings("all") public class throw_$Current$File_1_1 extends Strategy 
{ 
  public static throw_$Current$File_1_1 instance = new throw_$Current$File_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_10729, IStrategoTerm b_10729)
  { 
    context.push("throw_CurrentFile_1_1");
    Fail154:
    { 
      IStrategoTerm e_10729 = null;
      e_10729 = term;
      term = dr_throw_1_2.instance.invoke(context, e_10729, c_10729, b_10729, trans.const3);
      if(term == null)
        break Fail154;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}