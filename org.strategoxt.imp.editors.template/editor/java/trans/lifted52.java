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

@SuppressWarnings("all") final class lifted52 extends Strategy 
{ 
  public static final lifted52 instance = new lifted52();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail218:
    { 
      IStrategoTerm m_10731 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail218;
      m_10731 = term.getSubterm(0);
      IStrategoTerm arg42 = term.getSubterm(1);
      term = aux_$Current$File_0_1.instance.invoke(context, m_10731, arg42);
      if(term == null)
        break Fail218;
      if(true)
        return term;
    }
    return null;
  }
}