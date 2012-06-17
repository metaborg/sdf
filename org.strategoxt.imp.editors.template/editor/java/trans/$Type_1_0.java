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

@SuppressWarnings("all") public class $Type_1_0 extends Strategy 
{ 
  public static $Type_1_0 instance = new $Type_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_33009)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Type_1_0");
    Fail1968:
    { 
      IStrategoTerm n_33188 = null;
      IStrategoTerm m_33188 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consType_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1968;
      m_33188 = term.getSubterm(0);
      IStrategoList annos137 = term.getAnnotations();
      n_33188 = annos137;
      term = y_33009.invoke(context, m_33188);
      if(term == null)
        break Fail1968;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consType_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, n_33188));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}