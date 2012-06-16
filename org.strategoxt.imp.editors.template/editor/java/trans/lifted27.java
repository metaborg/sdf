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

@SuppressWarnings("all") final class lifted27 extends Strategy 
{ 
  public static final lifted27 instance = new lifted27();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail236:
    { 
      IStrategoTerm p_10718 = null;
      IStrategoTerm t_10718 = null;
      p_10718 = term;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consprod_3 != ((IStrategoAppl)term).getConstructor())
        break Fail236;
      t_10718 = term.getSubterm(2);
      term = t_10718;
      IStrategoTerm term48 = term;
      Success67:
      { 
        Fail237:
        { 
          term = fetch_cons_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail237;
          if(true)
            break Success67;
        }
        term = is_bracket_0_0.instance.invoke(context, term48);
        if(term == null)
          break Fail236;
      }
      term = p_10718;
      if(true)
        return term;
    }
    return null;
  }
}