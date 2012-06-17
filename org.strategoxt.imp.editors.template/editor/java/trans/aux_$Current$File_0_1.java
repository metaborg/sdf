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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm r_33019)
  { 
    Fail2025:
    { 
      IStrategoTerm s_33019 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2025;
      IStrategoTerm arg828 = term.getSubterm(0);
      if(arg828.getTermType() != IStrategoTerm.STRING || !"99705".equals(((IStrategoString)arg828).stringValue()))
        break Fail2025;
      s_33019 = term.getSubterm(1);
      term = s_33019;
      if(true)
        return term;
    }
    context.push("aux_CurrentFile_0_1");
    context.popOnFailure();
    return null;
  }
}