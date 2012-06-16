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

@SuppressWarnings("all") public class aux_$Current$File_0_1 extends Strategy 
{ 
  public static aux_$Current$File_0_1 instance = new aux_$Current$File_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm b_10733)
  { 
    Fail177:
    { 
      IStrategoTerm c_10733 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail177;
      IStrategoTerm arg43 = term.getSubterm(0);
      if(arg43.getTermType() != IStrategoTerm.STRING || !"99705".equals(((IStrategoString)arg43).stringValue()))
        break Fail177;
      c_10733 = term.getSubterm(1);
      term = c_10733;
      if(true)
        return term;
    }
    context.push("aux_CurrentFile_0_1");
    context.popOnFailure();
    return null;
  }
}