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

@SuppressWarnings("all") public class $Entity_2_0 extends Strategy 
{ 
  public static $Entity_2_0 instance = new $Entity_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_10723, Strategy f_10723)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Entity_2_0");
    Fail120:
    { 
      IStrategoTerm o_10901 = null;
      IStrategoTerm m_10901 = null;
      IStrategoTerm n_10901 = null;
      IStrategoTerm p_10901 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consEntity_2 != ((IStrategoAppl)term).getConstructor())
        break Fail120;
      m_10901 = term.getSubterm(0);
      n_10901 = term.getSubterm(1);
      IStrategoList annos3 = term.getAnnotations();
      o_10901 = annos3;
      term = e_10723.invoke(context, m_10901);
      if(term == null)
        break Fail120;
      p_10901 = term;
      term = f_10723.invoke(context, n_10901);
      if(term == null)
        break Fail120;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consEntity_2, new IStrategoTerm[]{p_10901, term}), checkListAnnos(termFactory, o_10901));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}