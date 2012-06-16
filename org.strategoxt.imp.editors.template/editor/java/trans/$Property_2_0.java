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

@SuppressWarnings("all") public class $Property_2_0 extends Strategy 
{ 
  public static $Property_2_0 instance = new $Property_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_10723, Strategy h_10723)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Property_2_0");
    Fail121:
    { 
      IStrategoTerm t_10901 = null;
      IStrategoTerm r_10901 = null;
      IStrategoTerm s_10901 = null;
      IStrategoTerm u_10901 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consProperty_2 != ((IStrategoAppl)term).getConstructor())
        break Fail121;
      r_10901 = term.getSubterm(0);
      s_10901 = term.getSubterm(1);
      IStrategoList annos4 = term.getAnnotations();
      t_10901 = annos4;
      term = g_10723.invoke(context, r_10901);
      if(term == null)
        break Fail121;
      u_10901 = term;
      term = h_10723.invoke(context, s_10901);
      if(term == null)
        break Fail121;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consProperty_2, new IStrategoTerm[]{u_10901, term}), checkListAnnos(termFactory, t_10901));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}