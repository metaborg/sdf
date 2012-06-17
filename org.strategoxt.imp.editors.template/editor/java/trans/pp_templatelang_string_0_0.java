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
    Fail1851:
    { 
      IStrategoTerm t_32992 = null;
      IStrategoTerm u_32992 = null;
      IStrategoTerm z_32992 = null;
      t_32992 = term;
      u_32992 = trans.constTemplateLangGeneratedPpAf;
      term = (IStrategoTerm)termFactory.makeListCons(u_32992, termFactory.makeListCons(trans.constTemplateLangPpAf, (IStrategoList)trans.constNil4));
      term = ast2abox_0_1.instance.invoke(context, t_32992, term);
      if(term == null)
        break Fail1851;
      z_32992 = term;
      term = box2text_string_0_1.instance.invoke(context, z_32992, trans.const271);
      if(term == null)
        break Fail1851;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}