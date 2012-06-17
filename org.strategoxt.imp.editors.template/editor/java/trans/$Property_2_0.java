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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_33009, Strategy x_33009)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Property_2_0");
    Fail1967:
    { 
      IStrategoTerm j_33188 = null;
      IStrategoTerm h_33188 = null;
      IStrategoTerm i_33188 = null;
      IStrategoTerm k_33188 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consProperty_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1967;
      h_33188 = term.getSubterm(0);
      i_33188 = term.getSubterm(1);
      IStrategoList annos136 = term.getAnnotations();
      j_33188 = annos136;
      term = w_33009.invoke(context, h_33188);
      if(term == null)
        break Fail1967;
      k_33188 = term;
      term = x_33009.invoke(context, i_33188);
      if(term == null)
        break Fail1967;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consProperty_2, new IStrategoTerm[]{k_33188, term}), checkListAnnos(termFactory, j_33188));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}