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

@SuppressWarnings("all") public class pp_templatelang_string_0_0 extends Strategy 
{ 
  public static pp_templatelang_string_0_0 instance = new pp_templatelang_string_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("pp_templatelang_string_0_0");
    Fail11:
    { 
      IStrategoTerm g_10707 = null;
      IStrategoTerm h_10707 = null;
      IStrategoTerm m_10707 = null;
      g_10707 = term;
      h_10707 = trans.constTemplateLangGeneratedPpAf;
      term = (IStrategoTerm)termFactory.makeListCons(h_10707, termFactory.makeListCons(trans.constTemplateLangPpAf, (IStrategoList)trans.constNil0));
      term = ast2abox_0_1.instance.invoke(context, g_10707, term);
      if(term == null)
        break Fail11;
      m_10707 = term;
      term = box2text_string_0_1.instance.invoke(context, m_10707, trans.const2);
      if(term == null)
        break Fail11;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}