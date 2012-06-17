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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_33009, Strategy v_33009)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Entity_2_0");
    Fail1966:
    { 
      IStrategoTerm e_33188 = null;
      IStrategoTerm c_33188 = null;
      IStrategoTerm d_33188 = null;
      IStrategoTerm f_33188 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consEntity_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1966;
      c_33188 = term.getSubterm(0);
      d_33188 = term.getSubterm(1);
      IStrategoList annos135 = term.getAnnotations();
      e_33188 = annos135;
      term = u_33009.invoke(context, c_33188);
      if(term == null)
        break Fail1966;
      f_33188 = term;
      term = v_33009.invoke(context, d_33188);
      if(term == null)
        break Fail1966;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consEntity_2, new IStrategoTerm[]{f_33188, term}), checkListAnnos(termFactory, e_33188));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}